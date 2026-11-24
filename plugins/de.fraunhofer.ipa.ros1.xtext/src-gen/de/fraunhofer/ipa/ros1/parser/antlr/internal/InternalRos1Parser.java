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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ExternalDependency", "RelativeNamespace", "PrivateNamespace", "GlobalNamespace", "Serviceclients", "Serviceservers", "Actionclients", "Actionservers", "Dependencies", "ParameterAny", "FromGitRepo", "Pluginslots", "Subscribers", "Implements", "Parameters", "Publishers", "Artifacts", "Parameter", "GraphName", "Multiple", "Actions", "Default", "Duration", "Feedback", "Plugins", "Response", "Boolean", "Integer", "Float32", "Float64", "Format", "Library", "Message", "Param", "Request", "Service", "Base64", "Double", "Header", "String", "Struct", "Action", "Result", "String_1", "Uint16", "Uint32", "Uint64", "Value_1", "Array", "Base", "Class", "Int16", "Int32", "Int64", "Msgs", "Node_1", "Pub", "Srvs", "Sub", "Type_1", "Uint8", "Value", "Date", "List", "Ac", "As", "Bool", "Byte", "Char", "Goal", "Int8", "Name", "Node", "Sc", "Ss", "Time", "Type", "Any", "Ns", "LessThanSignEqualsSign", "Comma", "FullStop", "Colon", "CommercialAt", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", "RULE_DIGIT", "RULE_BINARY", "RULE_BOOLEAN", "RULE_DECINT", "RULE_DOUBLE", "RULE_DAY", "RULE_MONTH", "RULE_YEAR", "RULE_HOUR", "RULE_MIN_SEC", "RULE_DATE_TIME", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_MESSAGE_ASIGMENT", "RULE_BEGIN", "RULE_END", "RULE_SL_COMMENT", "RULE_ROS_CONVENTION_A", "RULE_ROS_CONVENTION_PARAM", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Node=76;
    public static final int RULE_DATE_TIME=102;
    public static final int Serviceclients=8;
    public static final int String=43;
    public static final int Int16=55;
    public static final int Float32=32;
    public static final int Goal=73;
    public static final int Actionservers=11;
    public static final int Bool=70;
    public static final int Msgs=58;
    public static final int Uint16=48;
    public static final int Boolean=30;
    public static final int ExternalDependency=4;
    public static final int Sub=62;
    public static final int Uint8=64;
    public static final int Parameters=18;
    public static final int RULE_ID=103;
    public static final int Actions=24;
    public static final int RULE_DIGIT=92;
    public static final int GlobalNamespace=7;
    public static final int Artifacts=20;
    public static final int Node_1=59;
    public static final int Header=42;
    public static final int RULE_INT=105;
    public static final int Byte=71;
    public static final int RULE_ML_COMMENT=112;
    public static final int LeftSquareBracket=88;
    public static final int Pluginslots=15;
    public static final int Ac=68;
    public static final int Base64=40;
    public static final int Comma=84;
    public static final int As=69;
    public static final int RULE_MESSAGE_ASIGMENT=106;
    public static final int Int32=56;
    public static final int Char=72;
    public static final int Publishers=19;
    public static final int Srvs=61;
    public static final int LessThanSignEqualsSign=83;
    public static final int RightCurlyBracket=91;
    public static final int RULE_DECINT=95;
    public static final int Uint32=49;
    public static final int Plugins=28;
    public static final int FromGitRepo=14;
    public static final int FullStop=85;
    public static final int RULE_HOUR=100;
    public static final int Int8=74;
    public static final int Default=25;
    public static final int CommercialAt=87;
    public static final int Sc=77;
    public static final int Type=80;
    public static final int Float64=33;
    public static final int Parameter=21;
    public static final int RULE_BINARY=93;
    public static final int String_1=47;
    public static final int Subscribers=16;
    public static final int Ss=78;
    public static final int Actionclients=10;
    public static final int RULE_DAY=97;
    public static final int RULE_BEGIN=107;
    public static final int RULE_BOOLEAN=94;
    public static final int RelativeNamespace=5;
    public static final int Serviceservers=9;
    public static final int RULE_YEAR=99;
    public static final int Result=46;
    public static final int Name=75;
    public static final int RULE_MIN_SEC=101;
    public static final int Implements=17;
    public static final int ParameterAny=13;
    public static final int List=67;
    public static final int Dependencies=12;
    public static final int RightSquareBracket=89;
    public static final int PrivateNamespace=6;
    public static final int GraphName=22;
    public static final int Duration=26;
    public static final int Double=41;
    public static final int Type_1=63;
    public static final int Value=65;
    public static final int Class=54;
    public static final int Library=35;
    public static final int Uint64=50;
    public static final int Action=45;
    public static final int RULE_END=108;
    public static final int Message=36;
    public static final int Value_1=51;
    public static final int Time=79;
    public static final int RULE_STRING=104;
    public static final int Any=81;
    public static final int Struct=44;
    public static final int RULE_SL_COMMENT=109;
    public static final int Format=34;
    public static final int RULE_DOUBLE=96;
    public static final int Feedback=27;
    public static final int RULE_ROS_CONVENTION_A=110;
    public static final int RULE_ROS_CONVENTION_PARAM=111;
    public static final int Colon=86;
    public static final int Pub=60;
    public static final int EOF=-1;
    public static final int Multiple=23;
    public static final int Ns=82;
    public static final int RULE_WS=113;
    public static final int Request=38;
    public static final int LeftCurlyBracket=90;
    public static final int Service=39;
    public static final int RULE_ANY_OTHER=114;
    public static final int Base=53;
    public static final int Date=66;
    public static final int Response=29;
    public static final int Integer=31;
    public static final int Array=52;
    public static final int Int64=57;
    public static final int Param=37;
    public static final int RULE_MONTH=98;

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
    // InternalRos1Parser.g:90:1: ruleCatkinPackage returns [EObject current=null] : ( () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= FromGitRepo ( (lv_fromGitRepo_6_0= ruleEString ) ) )? (otherlv_7= Artifacts this_BEGIN_8= RULE_BEGIN ( (lv_artifact_9_0= ruleArtifact ) )* this_END_10= RULE_END )? (otherlv_11= Dependencies otherlv_12= LeftSquareBracket ( (lv_dependency_13_0= ruleDependency ) ) (otherlv_14= Comma ( (lv_dependency_15_0= ruleDependency ) ) )* otherlv_16= RightSquareBracket )? this_END_17= RULE_END ) ;
    public final EObject ruleCatkinPackage() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token this_BEGIN_8=null;
        Token this_END_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token this_END_17=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        AntlrDatatypeRuleToken lv_fromGitRepo_6_0 = null;

        EObject lv_artifact_9_0 = null;

        EObject lv_dependency_13_0 = null;

        EObject lv_dependency_15_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:96:2: ( ( () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= FromGitRepo ( (lv_fromGitRepo_6_0= ruleEString ) ) )? (otherlv_7= Artifacts this_BEGIN_8= RULE_BEGIN ( (lv_artifact_9_0= ruleArtifact ) )* this_END_10= RULE_END )? (otherlv_11= Dependencies otherlv_12= LeftSquareBracket ( (lv_dependency_13_0= ruleDependency ) ) (otherlv_14= Comma ( (lv_dependency_15_0= ruleDependency ) ) )* otherlv_16= RightSquareBracket )? this_END_17= RULE_END ) )
            // InternalRos1Parser.g:97:2: ( () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= FromGitRepo ( (lv_fromGitRepo_6_0= ruleEString ) ) )? (otherlv_7= Artifacts this_BEGIN_8= RULE_BEGIN ( (lv_artifact_9_0= ruleArtifact ) )* this_END_10= RULE_END )? (otherlv_11= Dependencies otherlv_12= LeftSquareBracket ( (lv_dependency_13_0= ruleDependency ) ) (otherlv_14= Comma ( (lv_dependency_15_0= ruleDependency ) ) )* otherlv_16= RightSquareBracket )? this_END_17= RULE_END )
            {
            // InternalRos1Parser.g:97:2: ( () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= FromGitRepo ( (lv_fromGitRepo_6_0= ruleEString ) ) )? (otherlv_7= Artifacts this_BEGIN_8= RULE_BEGIN ( (lv_artifact_9_0= ruleArtifact ) )* this_END_10= RULE_END )? (otherlv_11= Dependencies otherlv_12= LeftSquareBracket ( (lv_dependency_13_0= ruleDependency ) ) (otherlv_14= Comma ( (lv_dependency_15_0= ruleDependency ) ) )* otherlv_16= RightSquareBracket )? this_END_17= RULE_END )
            // InternalRos1Parser.g:98:3: () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= FromGitRepo ( (lv_fromGitRepo_6_0= ruleEString ) ) )? (otherlv_7= Artifacts this_BEGIN_8= RULE_BEGIN ( (lv_artifact_9_0= ruleArtifact ) )* this_END_10= RULE_END )? (otherlv_11= Dependencies otherlv_12= LeftSquareBracket ( (lv_dependency_13_0= ruleDependency ) ) (otherlv_14= Comma ( (lv_dependency_15_0= ruleDependency ) ) )* otherlv_16= RightSquareBracket )? this_END_17= RULE_END
            {
            // InternalRos1Parser.g:98:3: ()
            // InternalRos1Parser.g:99:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCatkinPackageAccess().getCatkinPackageAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:105:3: ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==Library||LA1_0==Class||LA1_0==Node||LA1_0==RULE_ID||LA1_0==RULE_ROS_CONVENTION_A) ) {
                alt1=1;
            }
            else if ( (LA1_0==Pluginslots||LA1_0==Implements||LA1_0==Parameter||LA1_0==Multiple||LA1_0==Plugins||LA1_0==Format||LA1_0==Base) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalRos1Parser.g:106:4: ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon )
                    {
                    // InternalRos1Parser.g:106:4: ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon )
                    // InternalRos1Parser.g:107:5: ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon
                    {
                    // InternalRos1Parser.g:107:5: ( (lv_name_1_0= ruleRosNames ) )
                    // InternalRos1Parser.g:108:6: (lv_name_1_0= ruleRosNames )
                    {
                    // InternalRos1Parser.g:108:6: (lv_name_1_0= ruleRosNames )
                    // InternalRos1Parser.g:109:7: lv_name_1_0= ruleRosNames
                    {

                    							newCompositeNode(grammarAccess.getCatkinPackageAccess().getNameRosNamesParserRuleCall_1_0_0_0());
                    						
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

                    					newLeafNode(otherlv_2, grammarAccess.getCatkinPackageAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:132:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRos1Parser.g:132:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRos1Parser.g:133:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRos1Parser.g:133:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRos1Parser.g:134:6: lv_name_3_0= ruleAddedKeywordName
                    {

                    						newCompositeNode(grammarAccess.getCatkinPackageAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_4);
                    lv_name_3_0=ruleAddedKeywordName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCatkinPackageRule());
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

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_5); 

            			newLeafNode(this_BEGIN_4, grammarAccess.getCatkinPackageAccess().getBEGINTerminalRuleCall_2());
            		
            // InternalRos1Parser.g:156:3: (otherlv_5= FromGitRepo ( (lv_fromGitRepo_6_0= ruleEString ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==FromGitRepo) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalRos1Parser.g:157:4: otherlv_5= FromGitRepo ( (lv_fromGitRepo_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,FromGitRepo,FOLLOW_6); 

                    				newLeafNode(otherlv_5, grammarAccess.getCatkinPackageAccess().getFromGitRepoKeyword_3_0());
                    			
                    // InternalRos1Parser.g:161:4: ( (lv_fromGitRepo_6_0= ruleEString ) )
                    // InternalRos1Parser.g:162:5: (lv_fromGitRepo_6_0= ruleEString )
                    {
                    // InternalRos1Parser.g:162:5: (lv_fromGitRepo_6_0= ruleEString )
                    // InternalRos1Parser.g:163:6: lv_fromGitRepo_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getCatkinPackageAccess().getFromGitRepoEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_fromGitRepo_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCatkinPackageRule());
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

            // InternalRos1Parser.g:181:3: (otherlv_7= Artifacts this_BEGIN_8= RULE_BEGIN ( (lv_artifact_9_0= ruleArtifact ) )* this_END_10= RULE_END )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==Artifacts) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalRos1Parser.g:182:4: otherlv_7= Artifacts this_BEGIN_8= RULE_BEGIN ( (lv_artifact_9_0= ruleArtifact ) )* this_END_10= RULE_END
                    {
                    otherlv_7=(Token)match(input,Artifacts,FOLLOW_4); 

                    				newLeafNode(otherlv_7, grammarAccess.getCatkinPackageAccess().getArtifactsKeyword_4_0());
                    			
                    this_BEGIN_8=(Token)match(input,RULE_BEGIN,FOLLOW_8); 

                    				newLeafNode(this_BEGIN_8, grammarAccess.getCatkinPackageAccess().getBEGINTerminalRuleCall_4_1());
                    			
                    // InternalRos1Parser.g:190:4: ( (lv_artifact_9_0= ruleArtifact ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==Pluginslots||LA3_0==Implements||LA3_0==Parameter||LA3_0==Multiple||LA3_0==Plugins||(LA3_0>=Format && LA3_0<=Library)||(LA3_0>=Base && LA3_0<=Class)||LA3_0==Node||LA3_0==RULE_ID||LA3_0==RULE_ROS_CONVENTION_A) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalRos1Parser.g:191:5: (lv_artifact_9_0= ruleArtifact )
                    	    {
                    	    // InternalRos1Parser.g:191:5: (lv_artifact_9_0= ruleArtifact )
                    	    // InternalRos1Parser.g:192:6: lv_artifact_9_0= ruleArtifact
                    	    {

                    	    						newCompositeNode(grammarAccess.getCatkinPackageAccess().getArtifactArtifactParserRuleCall_4_2_0());
                    	    					
                    	    pushFollow(FOLLOW_8);
                    	    lv_artifact_9_0=ruleArtifact();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getCatkinPackageRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"artifact",
                    	    							lv_artifact_9_0,
                    	    							"de.fraunhofer.ipa.ros.Ros.Artifact");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    this_END_10=(Token)match(input,RULE_END,FOLLOW_9); 

                    				newLeafNode(this_END_10, grammarAccess.getCatkinPackageAccess().getENDTerminalRuleCall_4_3());
                    			

                    }
                    break;

            }

            // InternalRos1Parser.g:214:3: (otherlv_11= Dependencies otherlv_12= LeftSquareBracket ( (lv_dependency_13_0= ruleDependency ) ) (otherlv_14= Comma ( (lv_dependency_15_0= ruleDependency ) ) )* otherlv_16= RightSquareBracket )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Dependencies) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalRos1Parser.g:215:4: otherlv_11= Dependencies otherlv_12= LeftSquareBracket ( (lv_dependency_13_0= ruleDependency ) ) (otherlv_14= Comma ( (lv_dependency_15_0= ruleDependency ) ) )* otherlv_16= RightSquareBracket
                    {
                    otherlv_11=(Token)match(input,Dependencies,FOLLOW_10); 

                    				newLeafNode(otherlv_11, grammarAccess.getCatkinPackageAccess().getDependenciesKeyword_5_0());
                    			
                    otherlv_12=(Token)match(input,LeftSquareBracket,FOLLOW_11); 

                    				newLeafNode(otherlv_12, grammarAccess.getCatkinPackageAccess().getLeftSquareBracketKeyword_5_1());
                    			
                    // InternalRos1Parser.g:223:4: ( (lv_dependency_13_0= ruleDependency ) )
                    // InternalRos1Parser.g:224:5: (lv_dependency_13_0= ruleDependency )
                    {
                    // InternalRos1Parser.g:224:5: (lv_dependency_13_0= ruleDependency )
                    // InternalRos1Parser.g:225:6: lv_dependency_13_0= ruleDependency
                    {

                    						newCompositeNode(grammarAccess.getCatkinPackageAccess().getDependencyDependencyParserRuleCall_5_2_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_dependency_13_0=ruleDependency();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCatkinPackageRule());
                    						}
                    						add(
                    							current,
                    							"dependency",
                    							lv_dependency_13_0,
                    							"de.fraunhofer.ipa.ros.Ros.Dependency");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalRos1Parser.g:242:4: (otherlv_14= Comma ( (lv_dependency_15_0= ruleDependency ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==Comma) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalRos1Parser.g:243:5: otherlv_14= Comma ( (lv_dependency_15_0= ruleDependency ) )
                    	    {
                    	    otherlv_14=(Token)match(input,Comma,FOLLOW_11); 

                    	    					newLeafNode(otherlv_14, grammarAccess.getCatkinPackageAccess().getCommaKeyword_5_3_0());
                    	    				
                    	    // InternalRos1Parser.g:247:5: ( (lv_dependency_15_0= ruleDependency ) )
                    	    // InternalRos1Parser.g:248:6: (lv_dependency_15_0= ruleDependency )
                    	    {
                    	    // InternalRos1Parser.g:248:6: (lv_dependency_15_0= ruleDependency )
                    	    // InternalRos1Parser.g:249:7: lv_dependency_15_0= ruleDependency
                    	    {

                    	    							newCompositeNode(grammarAccess.getCatkinPackageAccess().getDependencyDependencyParserRuleCall_5_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
                    	    lv_dependency_15_0=ruleDependency();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getCatkinPackageRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"dependency",
                    	    								lv_dependency_15_0,
                    	    								"de.fraunhofer.ipa.ros.Ros.Dependency");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,RightSquareBracket,FOLLOW_13); 

                    				newLeafNode(otherlv_16, grammarAccess.getCatkinPackageAccess().getRightSquareBracketKeyword_5_4());
                    			

                    }
                    break;

            }

            this_END_17=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_17, grammarAccess.getCatkinPackageAccess().getENDTerminalRuleCall_6());
            		

            }


            }


            	leaveRule();

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
    // InternalRos1Parser.g:280:1: entryRulePackage_Impl returns [EObject current=null] : iv_rulePackage_Impl= rulePackage_Impl EOF ;
    public final EObject entryRulePackage_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackage_Impl = null;


        try {
            // InternalRos1Parser.g:280:53: (iv_rulePackage_Impl= rulePackage_Impl EOF )
            // InternalRos1Parser.g:281:2: iv_rulePackage_Impl= rulePackage_Impl EOF
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
    // InternalRos1Parser.g:287:1: rulePackage_Impl returns [EObject current=null] : ( () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= FromGitRepo ( (lv_fromGitRepo_6_0= ruleEString ) ) )? (otherlv_7= Dependencies otherlv_8= LeftSquareBracket ( (lv_dependency_9_0= ruleDependency ) ) (otherlv_10= Comma ( (lv_dependency_11_0= ruleDependency ) ) )* otherlv_12= RightSquareBracket )? ( (otherlv_13= Msgs this_BEGIN_14= RULE_BEGIN ( (lv_spec_15_0= ruleTopicSpec ) )* this_END_16= RULE_END ) | (otherlv_17= Srvs this_BEGIN_18= RULE_BEGIN ( (lv_spec_19_0= ruleServiceSpec ) )* this_END_20= RULE_END ) | (otherlv_21= Actions this_BEGIN_22= RULE_BEGIN ( (lv_spec_23_0= ruleActionSpec ) )* this_END_24= RULE_END ) )* this_END_25= RULE_END ) ;
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
            // InternalRos1Parser.g:293:2: ( ( () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= FromGitRepo ( (lv_fromGitRepo_6_0= ruleEString ) ) )? (otherlv_7= Dependencies otherlv_8= LeftSquareBracket ( (lv_dependency_9_0= ruleDependency ) ) (otherlv_10= Comma ( (lv_dependency_11_0= ruleDependency ) ) )* otherlv_12= RightSquareBracket )? ( (otherlv_13= Msgs this_BEGIN_14= RULE_BEGIN ( (lv_spec_15_0= ruleTopicSpec ) )* this_END_16= RULE_END ) | (otherlv_17= Srvs this_BEGIN_18= RULE_BEGIN ( (lv_spec_19_0= ruleServiceSpec ) )* this_END_20= RULE_END ) | (otherlv_21= Actions this_BEGIN_22= RULE_BEGIN ( (lv_spec_23_0= ruleActionSpec ) )* this_END_24= RULE_END ) )* this_END_25= RULE_END ) )
            // InternalRos1Parser.g:294:2: ( () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= FromGitRepo ( (lv_fromGitRepo_6_0= ruleEString ) ) )? (otherlv_7= Dependencies otherlv_8= LeftSquareBracket ( (lv_dependency_9_0= ruleDependency ) ) (otherlv_10= Comma ( (lv_dependency_11_0= ruleDependency ) ) )* otherlv_12= RightSquareBracket )? ( (otherlv_13= Msgs this_BEGIN_14= RULE_BEGIN ( (lv_spec_15_0= ruleTopicSpec ) )* this_END_16= RULE_END ) | (otherlv_17= Srvs this_BEGIN_18= RULE_BEGIN ( (lv_spec_19_0= ruleServiceSpec ) )* this_END_20= RULE_END ) | (otherlv_21= Actions this_BEGIN_22= RULE_BEGIN ( (lv_spec_23_0= ruleActionSpec ) )* this_END_24= RULE_END ) )* this_END_25= RULE_END )
            {
            // InternalRos1Parser.g:294:2: ( () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= FromGitRepo ( (lv_fromGitRepo_6_0= ruleEString ) ) )? (otherlv_7= Dependencies otherlv_8= LeftSquareBracket ( (lv_dependency_9_0= ruleDependency ) ) (otherlv_10= Comma ( (lv_dependency_11_0= ruleDependency ) ) )* otherlv_12= RightSquareBracket )? ( (otherlv_13= Msgs this_BEGIN_14= RULE_BEGIN ( (lv_spec_15_0= ruleTopicSpec ) )* this_END_16= RULE_END ) | (otherlv_17= Srvs this_BEGIN_18= RULE_BEGIN ( (lv_spec_19_0= ruleServiceSpec ) )* this_END_20= RULE_END ) | (otherlv_21= Actions this_BEGIN_22= RULE_BEGIN ( (lv_spec_23_0= ruleActionSpec ) )* this_END_24= RULE_END ) )* this_END_25= RULE_END )
            // InternalRos1Parser.g:295:3: () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= FromGitRepo ( (lv_fromGitRepo_6_0= ruleEString ) ) )? (otherlv_7= Dependencies otherlv_8= LeftSquareBracket ( (lv_dependency_9_0= ruleDependency ) ) (otherlv_10= Comma ( (lv_dependency_11_0= ruleDependency ) ) )* otherlv_12= RightSquareBracket )? ( (otherlv_13= Msgs this_BEGIN_14= RULE_BEGIN ( (lv_spec_15_0= ruleTopicSpec ) )* this_END_16= RULE_END ) | (otherlv_17= Srvs this_BEGIN_18= RULE_BEGIN ( (lv_spec_19_0= ruleServiceSpec ) )* this_END_20= RULE_END ) | (otherlv_21= Actions this_BEGIN_22= RULE_BEGIN ( (lv_spec_23_0= ruleActionSpec ) )* this_END_24= RULE_END ) )* this_END_25= RULE_END
            {
            // InternalRos1Parser.g:295:3: ()
            // InternalRos1Parser.g:296:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPackage_ImplAccess().getPackageAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:302:3: ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==Library||LA7_0==Class||LA7_0==Node||LA7_0==RULE_ID||LA7_0==RULE_ROS_CONVENTION_A) ) {
                alt7=1;
            }
            else if ( (LA7_0==Pluginslots||LA7_0==Implements||LA7_0==Parameter||LA7_0==Multiple||LA7_0==Plugins||LA7_0==Format||LA7_0==Base) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalRos1Parser.g:303:4: ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon )
                    {
                    // InternalRos1Parser.g:303:4: ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon )
                    // InternalRos1Parser.g:304:5: ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon
                    {
                    // InternalRos1Parser.g:304:5: ( (lv_name_1_0= ruleRosNames ) )
                    // InternalRos1Parser.g:305:6: (lv_name_1_0= ruleRosNames )
                    {
                    // InternalRos1Parser.g:305:6: (lv_name_1_0= ruleRosNames )
                    // InternalRos1Parser.g:306:7: lv_name_1_0= ruleRosNames
                    {

                    							newCompositeNode(grammarAccess.getPackage_ImplAccess().getNameRosNamesParserRuleCall_1_0_0_0());
                    						
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

                    					newLeafNode(otherlv_2, grammarAccess.getPackage_ImplAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:329:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRos1Parser.g:329:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRos1Parser.g:330:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRos1Parser.g:330:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRos1Parser.g:331:6: lv_name_3_0= ruleAddedKeywordName
                    {

                    						newCompositeNode(grammarAccess.getPackage_ImplAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_4);
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

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_14); 

            			newLeafNode(this_BEGIN_4, grammarAccess.getPackage_ImplAccess().getBEGINTerminalRuleCall_2());
            		
            // InternalRos1Parser.g:353:3: (otherlv_5= FromGitRepo ( (lv_fromGitRepo_6_0= ruleEString ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==FromGitRepo) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalRos1Parser.g:354:4: otherlv_5= FromGitRepo ( (lv_fromGitRepo_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,FromGitRepo,FOLLOW_6); 

                    				newLeafNode(otherlv_5, grammarAccess.getPackage_ImplAccess().getFromGitRepoKeyword_3_0());
                    			
                    // InternalRos1Parser.g:358:4: ( (lv_fromGitRepo_6_0= ruleEString ) )
                    // InternalRos1Parser.g:359:5: (lv_fromGitRepo_6_0= ruleEString )
                    {
                    // InternalRos1Parser.g:359:5: (lv_fromGitRepo_6_0= ruleEString )
                    // InternalRos1Parser.g:360:6: lv_fromGitRepo_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getPackage_ImplAccess().getFromGitRepoEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_15);
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

            // InternalRos1Parser.g:378:3: (otherlv_7= Dependencies otherlv_8= LeftSquareBracket ( (lv_dependency_9_0= ruleDependency ) ) (otherlv_10= Comma ( (lv_dependency_11_0= ruleDependency ) ) )* otherlv_12= RightSquareBracket )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==Dependencies) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalRos1Parser.g:379:4: otherlv_7= Dependencies otherlv_8= LeftSquareBracket ( (lv_dependency_9_0= ruleDependency ) ) (otherlv_10= Comma ( (lv_dependency_11_0= ruleDependency ) ) )* otherlv_12= RightSquareBracket
                    {
                    otherlv_7=(Token)match(input,Dependencies,FOLLOW_10); 

                    				newLeafNode(otherlv_7, grammarAccess.getPackage_ImplAccess().getDependenciesKeyword_4_0());
                    			
                    otherlv_8=(Token)match(input,LeftSquareBracket,FOLLOW_11); 

                    				newLeafNode(otherlv_8, grammarAccess.getPackage_ImplAccess().getLeftSquareBracketKeyword_4_1());
                    			
                    // InternalRos1Parser.g:387:4: ( (lv_dependency_9_0= ruleDependency ) )
                    // InternalRos1Parser.g:388:5: (lv_dependency_9_0= ruleDependency )
                    {
                    // InternalRos1Parser.g:388:5: (lv_dependency_9_0= ruleDependency )
                    // InternalRos1Parser.g:389:6: lv_dependency_9_0= ruleDependency
                    {

                    						newCompositeNode(grammarAccess.getPackage_ImplAccess().getDependencyDependencyParserRuleCall_4_2_0());
                    					
                    pushFollow(FOLLOW_12);
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

                    // InternalRos1Parser.g:406:4: (otherlv_10= Comma ( (lv_dependency_11_0= ruleDependency ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==Comma) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalRos1Parser.g:407:5: otherlv_10= Comma ( (lv_dependency_11_0= ruleDependency ) )
                    	    {
                    	    otherlv_10=(Token)match(input,Comma,FOLLOW_11); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getPackage_ImplAccess().getCommaKeyword_4_3_0());
                    	    				
                    	    // InternalRos1Parser.g:411:5: ( (lv_dependency_11_0= ruleDependency ) )
                    	    // InternalRos1Parser.g:412:6: (lv_dependency_11_0= ruleDependency )
                    	    {
                    	    // InternalRos1Parser.g:412:6: (lv_dependency_11_0= ruleDependency )
                    	    // InternalRos1Parser.g:413:7: lv_dependency_11_0= ruleDependency
                    	    {

                    	    							newCompositeNode(grammarAccess.getPackage_ImplAccess().getDependencyDependencyParserRuleCall_4_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
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
                    	    break loop9;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,RightSquareBracket,FOLLOW_16); 

                    				newLeafNode(otherlv_12, grammarAccess.getPackage_ImplAccess().getRightSquareBracketKeyword_4_4());
                    			

                    }
                    break;

            }

            // InternalRos1Parser.g:436:3: ( (otherlv_13= Msgs this_BEGIN_14= RULE_BEGIN ( (lv_spec_15_0= ruleTopicSpec ) )* this_END_16= RULE_END ) | (otherlv_17= Srvs this_BEGIN_18= RULE_BEGIN ( (lv_spec_19_0= ruleServiceSpec ) )* this_END_20= RULE_END ) | (otherlv_21= Actions this_BEGIN_22= RULE_BEGIN ( (lv_spec_23_0= ruleActionSpec ) )* this_END_24= RULE_END ) )*
            loop14:
            do {
                int alt14=4;
                switch ( input.LA(1) ) {
                case Msgs:
                    {
                    alt14=1;
                    }
                    break;
                case Srvs:
                    {
                    alt14=2;
                    }
                    break;
                case Actions:
                    {
                    alt14=3;
                    }
                    break;

                }

                switch (alt14) {
            	case 1 :
            	    // InternalRos1Parser.g:437:4: (otherlv_13= Msgs this_BEGIN_14= RULE_BEGIN ( (lv_spec_15_0= ruleTopicSpec ) )* this_END_16= RULE_END )
            	    {
            	    // InternalRos1Parser.g:437:4: (otherlv_13= Msgs this_BEGIN_14= RULE_BEGIN ( (lv_spec_15_0= ruleTopicSpec ) )* this_END_16= RULE_END )
            	    // InternalRos1Parser.g:438:5: otherlv_13= Msgs this_BEGIN_14= RULE_BEGIN ( (lv_spec_15_0= ruleTopicSpec ) )* this_END_16= RULE_END
            	    {
            	    otherlv_13=(Token)match(input,Msgs,FOLLOW_4); 

            	    					newLeafNode(otherlv_13, grammarAccess.getPackage_ImplAccess().getMsgsKeyword_5_0_0());
            	    				
            	    this_BEGIN_14=(Token)match(input,RULE_BEGIN,FOLLOW_17); 

            	    					newLeafNode(this_BEGIN_14, grammarAccess.getPackage_ImplAccess().getBEGINTerminalRuleCall_5_0_1());
            	    				
            	    // InternalRos1Parser.g:446:5: ( (lv_spec_15_0= ruleTopicSpec ) )*
            	    loop11:
            	    do {
            	        int alt11=2;
            	        int LA11_0 = input.LA(1);

            	        if ( (LA11_0==Library||(LA11_0>=Header && LA11_0<=String)||LA11_0==Class||(LA11_0>=RULE_ID && LA11_0<=RULE_STRING)) ) {
            	            alt11=1;
            	        }


            	        switch (alt11) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:447:6: (lv_spec_15_0= ruleTopicSpec )
            	    	    {
            	    	    // InternalRos1Parser.g:447:6: (lv_spec_15_0= ruleTopicSpec )
            	    	    // InternalRos1Parser.g:448:7: lv_spec_15_0= ruleTopicSpec
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPackage_ImplAccess().getSpecTopicSpecParserRuleCall_5_0_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_17);
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
            	    	    break loop11;
            	        }
            	    } while (true);

            	    this_END_16=(Token)match(input,RULE_END,FOLLOW_16); 

            	    					newLeafNode(this_END_16, grammarAccess.getPackage_ImplAccess().getENDTerminalRuleCall_5_0_3());
            	    				

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRos1Parser.g:471:4: (otherlv_17= Srvs this_BEGIN_18= RULE_BEGIN ( (lv_spec_19_0= ruleServiceSpec ) )* this_END_20= RULE_END )
            	    {
            	    // InternalRos1Parser.g:471:4: (otherlv_17= Srvs this_BEGIN_18= RULE_BEGIN ( (lv_spec_19_0= ruleServiceSpec ) )* this_END_20= RULE_END )
            	    // InternalRos1Parser.g:472:5: otherlv_17= Srvs this_BEGIN_18= RULE_BEGIN ( (lv_spec_19_0= ruleServiceSpec ) )* this_END_20= RULE_END
            	    {
            	    otherlv_17=(Token)match(input,Srvs,FOLLOW_4); 

            	    					newLeafNode(otherlv_17, grammarAccess.getPackage_ImplAccess().getSrvsKeyword_5_1_0());
            	    				
            	    this_BEGIN_18=(Token)match(input,RULE_BEGIN,FOLLOW_18); 

            	    					newLeafNode(this_BEGIN_18, grammarAccess.getPackage_ImplAccess().getBEGINTerminalRuleCall_5_1_1());
            	    				
            	    // InternalRos1Parser.g:480:5: ( (lv_spec_19_0= ruleServiceSpec ) )*
            	    loop12:
            	    do {
            	        int alt12=2;
            	        int LA12_0 = input.LA(1);

            	        if ( (LA12_0==Library||LA12_0==Class||(LA12_0>=RULE_ID && LA12_0<=RULE_STRING)) ) {
            	            alt12=1;
            	        }


            	        switch (alt12) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:481:6: (lv_spec_19_0= ruleServiceSpec )
            	    	    {
            	    	    // InternalRos1Parser.g:481:6: (lv_spec_19_0= ruleServiceSpec )
            	    	    // InternalRos1Parser.g:482:7: lv_spec_19_0= ruleServiceSpec
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPackage_ImplAccess().getSpecServiceSpecParserRuleCall_5_1_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_18);
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
            	    	    break loop12;
            	        }
            	    } while (true);

            	    this_END_20=(Token)match(input,RULE_END,FOLLOW_16); 

            	    					newLeafNode(this_END_20, grammarAccess.getPackage_ImplAccess().getENDTerminalRuleCall_5_1_3());
            	    				

            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRos1Parser.g:505:4: (otherlv_21= Actions this_BEGIN_22= RULE_BEGIN ( (lv_spec_23_0= ruleActionSpec ) )* this_END_24= RULE_END )
            	    {
            	    // InternalRos1Parser.g:505:4: (otherlv_21= Actions this_BEGIN_22= RULE_BEGIN ( (lv_spec_23_0= ruleActionSpec ) )* this_END_24= RULE_END )
            	    // InternalRos1Parser.g:506:5: otherlv_21= Actions this_BEGIN_22= RULE_BEGIN ( (lv_spec_23_0= ruleActionSpec ) )* this_END_24= RULE_END
            	    {
            	    otherlv_21=(Token)match(input,Actions,FOLLOW_4); 

            	    					newLeafNode(otherlv_21, grammarAccess.getPackage_ImplAccess().getActionsKeyword_5_2_0());
            	    				
            	    this_BEGIN_22=(Token)match(input,RULE_BEGIN,FOLLOW_18); 

            	    					newLeafNode(this_BEGIN_22, grammarAccess.getPackage_ImplAccess().getBEGINTerminalRuleCall_5_2_1());
            	    				
            	    // InternalRos1Parser.g:514:5: ( (lv_spec_23_0= ruleActionSpec ) )*
            	    loop13:
            	    do {
            	        int alt13=2;
            	        int LA13_0 = input.LA(1);

            	        if ( (LA13_0==Library||LA13_0==Class||(LA13_0>=RULE_ID && LA13_0<=RULE_STRING)) ) {
            	            alt13=1;
            	        }


            	        switch (alt13) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:515:6: (lv_spec_23_0= ruleActionSpec )
            	    	    {
            	    	    // InternalRos1Parser.g:515:6: (lv_spec_23_0= ruleActionSpec )
            	    	    // InternalRos1Parser.g:516:7: lv_spec_23_0= ruleActionSpec
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPackage_ImplAccess().getSpecActionSpecParserRuleCall_5_2_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_18);
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
            	    	    break loop13;
            	        }
            	    } while (true);

            	    this_END_24=(Token)match(input,RULE_END,FOLLOW_16); 

            	    					newLeafNode(this_END_24, grammarAccess.getPackage_ImplAccess().getENDTerminalRuleCall_5_2_3());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // InternalRos1Parser.g:547:1: entryRuleTopicSpec returns [EObject current=null] : iv_ruleTopicSpec= ruleTopicSpec EOF ;
    public final EObject entryRuleTopicSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopicSpec = null;


        try {
            // InternalRos1Parser.g:547:50: (iv_ruleTopicSpec= ruleTopicSpec EOF )
            // InternalRos1Parser.g:548:2: iv_ruleTopicSpec= ruleTopicSpec EOF
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
    // InternalRos1Parser.g:554:1: ruleTopicSpec returns [EObject current=null] : ( () ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Message (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? this_END_7= RULE_END ) ;
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
            // InternalRos1Parser.g:560:2: ( ( () ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Message (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? this_END_7= RULE_END ) )
            // InternalRos1Parser.g:561:2: ( () ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Message (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? this_END_7= RULE_END )
            {
            // InternalRos1Parser.g:561:2: ( () ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Message (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? this_END_7= RULE_END )
            // InternalRos1Parser.g:562:3: () ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Message (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? this_END_7= RULE_END
            {
            // InternalRos1Parser.g:562:3: ()
            // InternalRos1Parser.g:563:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTopicSpecAccess().getTopicSpecAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:569:3: ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) )
            // InternalRos1Parser.g:570:4: ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) )
            {
            // InternalRos1Parser.g:570:4: ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) )
            // InternalRos1Parser.g:571:5: (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String )
            {
            // InternalRos1Parser.g:571:5: (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String )
            int alt15=3;
            switch ( input.LA(1) ) {
            case Library:
            case Class:
            case RULE_ID:
            case RULE_STRING:
                {
                alt15=1;
                }
                break;
            case Header:
                {
                alt15=2;
                }
                break;
            case String:
                {
                alt15=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalRos1Parser.g:572:6: lv_name_1_1= ruleEString
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
                    // InternalRos1Parser.g:588:6: lv_name_1_2= Header
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
                    // InternalRos1Parser.g:599:6: lv_name_1_3= String
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
            		
            // InternalRos1Parser.g:620:3: (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_BEGIN) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalRos1Parser.g:621:4: this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END
                    {
                    this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_21); 

                    				newLeafNode(this_BEGIN_4, grammarAccess.getTopicSpecAccess().getBEGINTerminalRuleCall_4_0());
                    			
                    // InternalRos1Parser.g:625:4: ( (lv_message_5_0= ruleMessageDefinition ) )
                    // InternalRos1Parser.g:626:5: (lv_message_5_0= ruleMessageDefinition )
                    {
                    // InternalRos1Parser.g:626:5: (lv_message_5_0= ruleMessageDefinition )
                    // InternalRos1Parser.g:627:6: lv_message_5_0= ruleMessageDefinition
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
    // InternalRos1Parser.g:657:1: entryRuleServiceSpec returns [EObject current=null] : iv_ruleServiceSpec= ruleServiceSpec EOF ;
    public final EObject entryRuleServiceSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceSpec = null;


        try {
            // InternalRos1Parser.g:657:52: (iv_ruleServiceSpec= ruleServiceSpec EOF )
            // InternalRos1Parser.g:658:2: iv_ruleServiceSpec= ruleServiceSpec EOF
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
    // InternalRos1Parser.g:664:1: ruleServiceSpec returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Request (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Response (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? this_END_11= RULE_END ) ;
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
            // InternalRos1Parser.g:670:2: ( ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Request (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Response (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? this_END_11= RULE_END ) )
            // InternalRos1Parser.g:671:2: ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Request (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Response (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? this_END_11= RULE_END )
            {
            // InternalRos1Parser.g:671:2: ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Request (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Response (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? this_END_11= RULE_END )
            // InternalRos1Parser.g:672:3: () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Request (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Response (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? this_END_11= RULE_END
            {
            // InternalRos1Parser.g:672:3: ()
            // InternalRos1Parser.g:673:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getServiceSpecAccess().getServiceSpecAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:679:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos1Parser.g:680:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos1Parser.g:680:4: (lv_name_1_0= ruleEString )
            // InternalRos1Parser.g:681:5: lv_name_1_0= ruleEString
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
            		
            // InternalRos1Parser.g:706:3: (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_BEGIN) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalRos1Parser.g:707:4: this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END
                    {
                    this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_21); 

                    				newLeafNode(this_BEGIN_4, grammarAccess.getServiceSpecAccess().getBEGINTerminalRuleCall_4_0());
                    			
                    // InternalRos1Parser.g:711:4: ( (lv_request_5_0= ruleMessageDefinition ) )
                    // InternalRos1Parser.g:712:5: (lv_request_5_0= ruleMessageDefinition )
                    {
                    // InternalRos1Parser.g:712:5: (lv_request_5_0= ruleMessageDefinition )
                    // InternalRos1Parser.g:713:6: lv_request_5_0= ruleMessageDefinition
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
            		
            // InternalRos1Parser.g:739:3: (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_BEGIN) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalRos1Parser.g:740:4: this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END
                    {
                    this_BEGIN_8=(Token)match(input,RULE_BEGIN,FOLLOW_21); 

                    				newLeafNode(this_BEGIN_8, grammarAccess.getServiceSpecAccess().getBEGINTerminalRuleCall_6_0());
                    			
                    // InternalRos1Parser.g:744:4: ( (lv_response_9_0= ruleMessageDefinition ) )
                    // InternalRos1Parser.g:745:5: (lv_response_9_0= ruleMessageDefinition )
                    {
                    // InternalRos1Parser.g:745:5: (lv_response_9_0= ruleMessageDefinition )
                    // InternalRos1Parser.g:746:6: lv_response_9_0= ruleMessageDefinition
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
    // InternalRos1Parser.g:776:1: entryRuleActionSpec returns [EObject current=null] : iv_ruleActionSpec= ruleActionSpec EOF ;
    public final EObject entryRuleActionSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionSpec = null;


        try {
            // InternalRos1Parser.g:776:51: (iv_ruleActionSpec= ruleActionSpec EOF )
            // InternalRos1Parser.g:777:2: iv_ruleActionSpec= ruleActionSpec EOF
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
    // InternalRos1Parser.g:783:1: ruleActionSpec returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Goal (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Result (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? otherlv_11= Feedback (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )? this_END_15= RULE_END ) ;
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
            // InternalRos1Parser.g:789:2: ( ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Goal (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Result (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? otherlv_11= Feedback (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )? this_END_15= RULE_END ) )
            // InternalRos1Parser.g:790:2: ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Goal (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Result (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? otherlv_11= Feedback (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )? this_END_15= RULE_END )
            {
            // InternalRos1Parser.g:790:2: ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Goal (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Result (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? otherlv_11= Feedback (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )? this_END_15= RULE_END )
            // InternalRos1Parser.g:791:3: () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Goal (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Result (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? otherlv_11= Feedback (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )? this_END_15= RULE_END
            {
            // InternalRos1Parser.g:791:3: ()
            // InternalRos1Parser.g:792:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getActionSpecAccess().getActionSpecAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:798:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos1Parser.g:799:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos1Parser.g:799:4: (lv_name_1_0= ruleEString )
            // InternalRos1Parser.g:800:5: lv_name_1_0= ruleEString
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
            		
            // InternalRos1Parser.g:825:3: (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_BEGIN) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalRos1Parser.g:826:4: this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END
                    {
                    this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_21); 

                    				newLeafNode(this_BEGIN_4, grammarAccess.getActionSpecAccess().getBEGINTerminalRuleCall_4_0());
                    			
                    // InternalRos1Parser.g:830:4: ( (lv_goal_5_0= ruleMessageDefinition ) )
                    // InternalRos1Parser.g:831:5: (lv_goal_5_0= ruleMessageDefinition )
                    {
                    // InternalRos1Parser.g:831:5: (lv_goal_5_0= ruleMessageDefinition )
                    // InternalRos1Parser.g:832:6: lv_goal_5_0= ruleMessageDefinition
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
            		
            // InternalRos1Parser.g:858:3: (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_BEGIN) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalRos1Parser.g:859:4: this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END
                    {
                    this_BEGIN_8=(Token)match(input,RULE_BEGIN,FOLLOW_21); 

                    				newLeafNode(this_BEGIN_8, grammarAccess.getActionSpecAccess().getBEGINTerminalRuleCall_6_0());
                    			
                    // InternalRos1Parser.g:863:4: ( (lv_result_9_0= ruleMessageDefinition ) )
                    // InternalRos1Parser.g:864:5: (lv_result_9_0= ruleMessageDefinition )
                    {
                    // InternalRos1Parser.g:864:5: (lv_result_9_0= ruleMessageDefinition )
                    // InternalRos1Parser.g:865:6: lv_result_9_0= ruleMessageDefinition
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
            		
            // InternalRos1Parser.g:891:3: (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_BEGIN) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalRos1Parser.g:892:4: this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END
                    {
                    this_BEGIN_12=(Token)match(input,RULE_BEGIN,FOLLOW_21); 

                    				newLeafNode(this_BEGIN_12, grammarAccess.getActionSpecAccess().getBEGINTerminalRuleCall_8_0());
                    			
                    // InternalRos1Parser.g:896:4: ( (lv_feedback_13_0= ruleMessageDefinition ) )
                    // InternalRos1Parser.g:897:5: (lv_feedback_13_0= ruleMessageDefinition )
                    {
                    // InternalRos1Parser.g:897:5: (lv_feedback_13_0= ruleMessageDefinition )
                    // InternalRos1Parser.g:898:6: lv_feedback_13_0= ruleMessageDefinition
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
    // InternalRos1Parser.g:928:1: entryRuleMessageDefinition returns [EObject current=null] : iv_ruleMessageDefinition= ruleMessageDefinition EOF ;
    public final EObject entryRuleMessageDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageDefinition = null;


        try {
            // InternalRos1Parser.g:928:58: (iv_ruleMessageDefinition= ruleMessageDefinition EOF )
            // InternalRos1Parser.g:929:2: iv_ruleMessageDefinition= ruleMessageDefinition EOF
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
    // InternalRos1Parser.g:935:1: ruleMessageDefinition returns [EObject current=null] : ( () ( (lv_MessagePart_1_0= ruleMessagePart ) )* ) ;
    public final EObject ruleMessageDefinition() throws RecognitionException {
        EObject current = null;

        EObject lv_MessagePart_1_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:941:2: ( ( () ( (lv_MessagePart_1_0= ruleMessagePart ) )* ) )
            // InternalRos1Parser.g:942:2: ( () ( (lv_MessagePart_1_0= ruleMessagePart ) )* )
            {
            // InternalRos1Parser.g:942:2: ( () ( (lv_MessagePart_1_0= ruleMessagePart ) )* )
            // InternalRos1Parser.g:943:3: () ( (lv_MessagePart_1_0= ruleMessagePart ) )*
            {
            // InternalRos1Parser.g:943:3: ()
            // InternalRos1Parser.g:944:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMessageDefinitionAccess().getMessageDefinitionAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:950:3: ( (lv_MessagePart_1_0= ruleMessagePart ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==Duration||(LA22_0>=Float32 && LA22_0<=Float64)||LA22_0==Library||LA22_0==Header||(LA22_0>=String_1 && LA22_0<=Uint64)||(LA22_0>=Class && LA22_0<=Int64)||LA22_0==Uint8||(LA22_0>=Bool && LA22_0<=Char)||LA22_0==Int8||LA22_0==Time||(LA22_0>=RULE_ID && LA22_0<=RULE_STRING)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalRos1Parser.g:951:4: (lv_MessagePart_1_0= ruleMessagePart )
            	    {
            	    // InternalRos1Parser.g:951:4: (lv_MessagePart_1_0= ruleMessagePart )
            	    // InternalRos1Parser.g:952:5: lv_MessagePart_1_0= ruleMessagePart
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
            	    break loop22;
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
    // InternalRos1Parser.g:973:1: entryRuleArtifact returns [EObject current=null] : iv_ruleArtifact= ruleArtifact EOF ;
    public final EObject entryRuleArtifact() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArtifact = null;


        try {
            // InternalRos1Parser.g:973:49: (iv_ruleArtifact= ruleArtifact EOF )
            // InternalRos1Parser.g:974:2: iv_ruleArtifact= ruleArtifact EOF
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
    // InternalRos1Parser.g:980:1: ruleArtifact returns [EObject current=null] : ( () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN ( ( (lv_node_5_0= ruleNode ) ) | (otherlv_6= Plugins this_BEGIN_7= RULE_BEGIN ( (lv_plugins_8_0= rulePlugin ) )* this_END_9= RULE_END ) )? this_END_10= RULE_END ) ;
    public final EObject ruleArtifact() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_4=null;
        Token otherlv_6=null;
        Token this_BEGIN_7=null;
        Token this_END_9=null;
        Token this_END_10=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_node_5_0 = null;

        EObject lv_plugins_8_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:986:2: ( ( () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN ( ( (lv_node_5_0= ruleNode ) ) | (otherlv_6= Plugins this_BEGIN_7= RULE_BEGIN ( (lv_plugins_8_0= rulePlugin ) )* this_END_9= RULE_END ) )? this_END_10= RULE_END ) )
            // InternalRos1Parser.g:987:2: ( () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN ( ( (lv_node_5_0= ruleNode ) ) | (otherlv_6= Plugins this_BEGIN_7= RULE_BEGIN ( (lv_plugins_8_0= rulePlugin ) )* this_END_9= RULE_END ) )? this_END_10= RULE_END )
            {
            // InternalRos1Parser.g:987:2: ( () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN ( ( (lv_node_5_0= ruleNode ) ) | (otherlv_6= Plugins this_BEGIN_7= RULE_BEGIN ( (lv_plugins_8_0= rulePlugin ) )* this_END_9= RULE_END ) )? this_END_10= RULE_END )
            // InternalRos1Parser.g:988:3: () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN ( ( (lv_node_5_0= ruleNode ) ) | (otherlv_6= Plugins this_BEGIN_7= RULE_BEGIN ( (lv_plugins_8_0= rulePlugin ) )* this_END_9= RULE_END ) )? this_END_10= RULE_END
            {
            // InternalRos1Parser.g:988:3: ()
            // InternalRos1Parser.g:989:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getArtifactAccess().getArtifactAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:995:3: ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==Library||LA23_0==Class||LA23_0==Node||LA23_0==RULE_ID||LA23_0==RULE_ROS_CONVENTION_A) ) {
                alt23=1;
            }
            else if ( (LA23_0==Pluginslots||LA23_0==Implements||LA23_0==Parameter||LA23_0==Multiple||LA23_0==Plugins||LA23_0==Format||LA23_0==Base) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalRos1Parser.g:996:4: ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon )
                    {
                    // InternalRos1Parser.g:996:4: ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon )
                    // InternalRos1Parser.g:997:5: ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon
                    {
                    // InternalRos1Parser.g:997:5: ( (lv_name_1_0= ruleRosNames ) )
                    // InternalRos1Parser.g:998:6: (lv_name_1_0= ruleRosNames )
                    {
                    // InternalRos1Parser.g:998:6: (lv_name_1_0= ruleRosNames )
                    // InternalRos1Parser.g:999:7: lv_name_1_0= ruleRosNames
                    {

                    							newCompositeNode(grammarAccess.getArtifactAccess().getNameRosNamesParserRuleCall_1_0_0_0());
                    						
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

                    					newLeafNode(otherlv_2, grammarAccess.getArtifactAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:1022:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRos1Parser.g:1022:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRos1Parser.g:1023:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRos1Parser.g:1023:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRos1Parser.g:1024:6: lv_name_3_0= ruleAddedKeywordName
                    {

                    						newCompositeNode(grammarAccess.getArtifactAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_4);
                    lv_name_3_0=ruleAddedKeywordName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getArtifactRule());
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

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_31); 

            			newLeafNode(this_BEGIN_4, grammarAccess.getArtifactAccess().getBEGINTerminalRuleCall_2());
            		
            // InternalRos1Parser.g:1046:3: ( ( (lv_node_5_0= ruleNode ) ) | (otherlv_6= Plugins this_BEGIN_7= RULE_BEGIN ( (lv_plugins_8_0= rulePlugin ) )* this_END_9= RULE_END ) )?
            int alt25=3;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==Node_1) ) {
                alt25=1;
            }
            else if ( (LA25_0==Plugins) ) {
                alt25=2;
            }
            switch (alt25) {
                case 1 :
                    // InternalRos1Parser.g:1047:4: ( (lv_node_5_0= ruleNode ) )
                    {
                    // InternalRos1Parser.g:1047:4: ( (lv_node_5_0= ruleNode ) )
                    // InternalRos1Parser.g:1048:5: (lv_node_5_0= ruleNode )
                    {
                    // InternalRos1Parser.g:1048:5: (lv_node_5_0= ruleNode )
                    // InternalRos1Parser.g:1049:6: lv_node_5_0= ruleNode
                    {

                    						newCompositeNode(grammarAccess.getArtifactAccess().getNodeNodeParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_node_5_0=ruleNode();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getArtifactRule());
                    						}
                    						set(
                    							current,
                    							"node",
                    							lv_node_5_0,
                    							"de.fraunhofer.ipa.ros.Ros.Node");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:1067:4: (otherlv_6= Plugins this_BEGIN_7= RULE_BEGIN ( (lv_plugins_8_0= rulePlugin ) )* this_END_9= RULE_END )
                    {
                    // InternalRos1Parser.g:1067:4: (otherlv_6= Plugins this_BEGIN_7= RULE_BEGIN ( (lv_plugins_8_0= rulePlugin ) )* this_END_9= RULE_END )
                    // InternalRos1Parser.g:1068:5: otherlv_6= Plugins this_BEGIN_7= RULE_BEGIN ( (lv_plugins_8_0= rulePlugin ) )* this_END_9= RULE_END
                    {
                    otherlv_6=(Token)match(input,Plugins,FOLLOW_4); 

                    					newLeafNode(otherlv_6, grammarAccess.getArtifactAccess().getPluginsKeyword_3_1_0());
                    				
                    this_BEGIN_7=(Token)match(input,RULE_BEGIN,FOLLOW_8); 

                    					newLeafNode(this_BEGIN_7, grammarAccess.getArtifactAccess().getBEGINTerminalRuleCall_3_1_1());
                    				
                    // InternalRos1Parser.g:1076:5: ( (lv_plugins_8_0= rulePlugin ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==Pluginslots||LA24_0==Implements||LA24_0==Parameter||LA24_0==Multiple||LA24_0==Plugins||(LA24_0>=Format && LA24_0<=Library)||(LA24_0>=Base && LA24_0<=Class)||LA24_0==Node||LA24_0==RULE_ID||LA24_0==RULE_ROS_CONVENTION_A) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalRos1Parser.g:1077:6: (lv_plugins_8_0= rulePlugin )
                    	    {
                    	    // InternalRos1Parser.g:1077:6: (lv_plugins_8_0= rulePlugin )
                    	    // InternalRos1Parser.g:1078:7: lv_plugins_8_0= rulePlugin
                    	    {

                    	    							newCompositeNode(grammarAccess.getArtifactAccess().getPluginsPluginParserRuleCall_3_1_2_0());
                    	    						
                    	    pushFollow(FOLLOW_8);
                    	    lv_plugins_8_0=rulePlugin();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getArtifactRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"plugins",
                    	    								lv_plugins_8_0,
                    	    								"de.fraunhofer.ipa.ros.Ros.Plugin");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    this_END_9=(Token)match(input,RULE_END,FOLLOW_13); 

                    					newLeafNode(this_END_9, grammarAccess.getArtifactAccess().getENDTerminalRuleCall_3_1_3());
                    				

                    }


                    }
                    break;

            }

            this_END_10=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_10, grammarAccess.getArtifactAccess().getENDTerminalRuleCall_4());
            		

            }


            }


            	leaveRule();

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
    // InternalRos1Parser.g:1109:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // InternalRos1Parser.g:1109:45: (iv_ruleNode= ruleNode EOF )
            // InternalRos1Parser.g:1110:2: iv_ruleNode= ruleNode EOF
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
    // InternalRos1Parser.g:1116:1: ruleNode returns [EObject current=null] : (otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) | (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END ) | ( (lv_extensions_34_0= ruleExtensionBlock ) ) )* ) ;
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
            // InternalRos1Parser.g:1122:2: ( (otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) | (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END ) | ( (lv_extensions_34_0= ruleExtensionBlock ) ) )* ) )
            // InternalRos1Parser.g:1123:2: (otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) | (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END ) | ( (lv_extensions_34_0= ruleExtensionBlock ) ) )* )
            {
            // InternalRos1Parser.g:1123:2: (otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) | (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END ) | ( (lv_extensions_34_0= ruleExtensionBlock ) ) )* )
            // InternalRos1Parser.g:1124:3: otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) | (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END ) | ( (lv_extensions_34_0= ruleExtensionBlock ) ) )*
            {
            otherlv_0=(Token)match(input,Node_1,FOLLOW_32); 

            			newLeafNode(otherlv_0, grammarAccess.getNodeAccess().getNodeKeyword_0());
            		
            // InternalRos1Parser.g:1128:3: ( (lv_name_1_0= ruleRosNames ) )
            // InternalRos1Parser.g:1129:4: (lv_name_1_0= ruleRosNames )
            {
            // InternalRos1Parser.g:1129:4: (lv_name_1_0= ruleRosNames )
            // InternalRos1Parser.g:1130:5: lv_name_1_0= ruleRosNames
            {

            					newCompositeNode(grammarAccess.getNodeAccess().getNameRosNamesParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_33);
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

            // InternalRos1Parser.g:1147:3: ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) | (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END ) | ( (lv_extensions_34_0= ruleExtensionBlock ) ) )*
            loop34:
            do {
                int alt34=10;
                switch ( input.LA(1) ) {
                case Publishers:
                    {
                    alt34=1;
                    }
                    break;
                case Subscribers:
                    {
                    alt34=2;
                    }
                    break;
                case Serviceservers:
                    {
                    alt34=3;
                    }
                    break;
                case Serviceclients:
                    {
                    alt34=4;
                    }
                    break;
                case Actionservers:
                    {
                    alt34=5;
                    }
                    break;
                case Actionclients:
                    {
                    alt34=6;
                    }
                    break;
                case Parameters:
                    {
                    alt34=7;
                    }
                    break;
                case Pluginslots:
                    {
                    alt34=8;
                    }
                    break;
                case CommercialAt:
                    {
                    alt34=9;
                    }
                    break;

                }

                switch (alt34) {
            	case 1 :
            	    // InternalRos1Parser.g:1148:4: (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1148:4: (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END )
            	    // InternalRos1Parser.g:1149:5: otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END
            	    {
            	    otherlv_2=(Token)match(input,Publishers,FOLLOW_4); 

            	    					newLeafNode(otherlv_2, grammarAccess.getNodeAccess().getPublishersKeyword_2_0_0());
            	    				
            	    this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_34); 

            	    					newLeafNode(this_BEGIN_3, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_0_1());
            	    				
            	    // InternalRos1Parser.g:1157:5: ( (lv_publisher_4_0= rulePublisher ) )*
            	    loop26:
            	    do {
            	        int alt26=2;
            	        int LA26_0 = input.LA(1);

            	        if ( (LA26_0==Pluginslots||LA26_0==Implements||LA26_0==Parameter||LA26_0==Multiple||LA26_0==Plugins||(LA26_0>=Format && LA26_0<=Library)||(LA26_0>=Base && LA26_0<=Class)||(LA26_0>=RULE_ID && LA26_0<=RULE_STRING)) ) {
            	            alt26=1;
            	        }


            	        switch (alt26) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1158:6: (lv_publisher_4_0= rulePublisher )
            	    	    {
            	    	    // InternalRos1Parser.g:1158:6: (lv_publisher_4_0= rulePublisher )
            	    	    // InternalRos1Parser.g:1159:7: lv_publisher_4_0= rulePublisher
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getPublisherPublisherParserRuleCall_2_0_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_34);
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
            	    	    break loop26;
            	        }
            	    } while (true);

            	    this_END_5=(Token)match(input,RULE_END,FOLLOW_33); 

            	    					newLeafNode(this_END_5, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_0_3());
            	    				

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRos1Parser.g:1182:4: (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1182:4: (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END )
            	    // InternalRos1Parser.g:1183:5: otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END
            	    {
            	    otherlv_6=(Token)match(input,Subscribers,FOLLOW_4); 

            	    					newLeafNode(otherlv_6, grammarAccess.getNodeAccess().getSubscribersKeyword_2_1_0());
            	    				
            	    this_BEGIN_7=(Token)match(input,RULE_BEGIN,FOLLOW_34); 

            	    					newLeafNode(this_BEGIN_7, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_1_1());
            	    				
            	    // InternalRos1Parser.g:1191:5: ( (lv_subscriber_8_0= ruleSubscriber ) )*
            	    loop27:
            	    do {
            	        int alt27=2;
            	        int LA27_0 = input.LA(1);

            	        if ( (LA27_0==Pluginslots||LA27_0==Implements||LA27_0==Parameter||LA27_0==Multiple||LA27_0==Plugins||(LA27_0>=Format && LA27_0<=Library)||(LA27_0>=Base && LA27_0<=Class)||(LA27_0>=RULE_ID && LA27_0<=RULE_STRING)) ) {
            	            alt27=1;
            	        }


            	        switch (alt27) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1192:6: (lv_subscriber_8_0= ruleSubscriber )
            	    	    {
            	    	    // InternalRos1Parser.g:1192:6: (lv_subscriber_8_0= ruleSubscriber )
            	    	    // InternalRos1Parser.g:1193:7: lv_subscriber_8_0= ruleSubscriber
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getSubscriberSubscriberParserRuleCall_2_1_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_34);
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
            	    	    break loop27;
            	        }
            	    } while (true);

            	    this_END_9=(Token)match(input,RULE_END,FOLLOW_33); 

            	    					newLeafNode(this_END_9, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_1_3());
            	    				

            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRos1Parser.g:1216:4: (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1216:4: (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END )
            	    // InternalRos1Parser.g:1217:5: otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END
            	    {
            	    otherlv_10=(Token)match(input,Serviceservers,FOLLOW_4); 

            	    					newLeafNode(otherlv_10, grammarAccess.getNodeAccess().getServiceserversKeyword_2_2_0());
            	    				
            	    this_BEGIN_11=(Token)match(input,RULE_BEGIN,FOLLOW_34); 

            	    					newLeafNode(this_BEGIN_11, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_2_1());
            	    				
            	    // InternalRos1Parser.g:1225:5: ( (lv_serviceserver_12_0= ruleServiceServer ) )*
            	    loop28:
            	    do {
            	        int alt28=2;
            	        int LA28_0 = input.LA(1);

            	        if ( (LA28_0==Pluginslots||LA28_0==Implements||LA28_0==Parameter||LA28_0==Multiple||LA28_0==Plugins||(LA28_0>=Format && LA28_0<=Library)||(LA28_0>=Base && LA28_0<=Class)||(LA28_0>=RULE_ID && LA28_0<=RULE_STRING)) ) {
            	            alt28=1;
            	        }


            	        switch (alt28) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1226:6: (lv_serviceserver_12_0= ruleServiceServer )
            	    	    {
            	    	    // InternalRos1Parser.g:1226:6: (lv_serviceserver_12_0= ruleServiceServer )
            	    	    // InternalRos1Parser.g:1227:7: lv_serviceserver_12_0= ruleServiceServer
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getServiceserverServiceServerParserRuleCall_2_2_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_34);
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
            	    	    break loop28;
            	        }
            	    } while (true);

            	    this_END_13=(Token)match(input,RULE_END,FOLLOW_33); 

            	    					newLeafNode(this_END_13, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_2_3());
            	    				

            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalRos1Parser.g:1250:4: (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1250:4: (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END )
            	    // InternalRos1Parser.g:1251:5: otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END
            	    {
            	    otherlv_14=(Token)match(input,Serviceclients,FOLLOW_4); 

            	    					newLeafNode(otherlv_14, grammarAccess.getNodeAccess().getServiceclientsKeyword_2_3_0());
            	    				
            	    this_BEGIN_15=(Token)match(input,RULE_BEGIN,FOLLOW_34); 

            	    					newLeafNode(this_BEGIN_15, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_3_1());
            	    				
            	    // InternalRos1Parser.g:1259:5: ( (lv_serviceclient_16_0= ruleServiceClient ) )*
            	    loop29:
            	    do {
            	        int alt29=2;
            	        int LA29_0 = input.LA(1);

            	        if ( (LA29_0==Pluginslots||LA29_0==Implements||LA29_0==Parameter||LA29_0==Multiple||LA29_0==Plugins||(LA29_0>=Format && LA29_0<=Library)||(LA29_0>=Base && LA29_0<=Class)||(LA29_0>=RULE_ID && LA29_0<=RULE_STRING)) ) {
            	            alt29=1;
            	        }


            	        switch (alt29) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1260:6: (lv_serviceclient_16_0= ruleServiceClient )
            	    	    {
            	    	    // InternalRos1Parser.g:1260:6: (lv_serviceclient_16_0= ruleServiceClient )
            	    	    // InternalRos1Parser.g:1261:7: lv_serviceclient_16_0= ruleServiceClient
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getServiceclientServiceClientParserRuleCall_2_3_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_34);
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
            	    	    break loop29;
            	        }
            	    } while (true);

            	    this_END_17=(Token)match(input,RULE_END,FOLLOW_33); 

            	    					newLeafNode(this_END_17, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_3_3());
            	    				

            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalRos1Parser.g:1284:4: (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1284:4: (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END )
            	    // InternalRos1Parser.g:1285:5: otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END
            	    {
            	    otherlv_18=(Token)match(input,Actionservers,FOLLOW_4); 

            	    					newLeafNode(otherlv_18, grammarAccess.getNodeAccess().getActionserversKeyword_2_4_0());
            	    				
            	    this_BEGIN_19=(Token)match(input,RULE_BEGIN,FOLLOW_34); 

            	    					newLeafNode(this_BEGIN_19, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_4_1());
            	    				
            	    // InternalRos1Parser.g:1293:5: ( (lv_actionserver_20_0= ruleActionServer ) )*
            	    loop30:
            	    do {
            	        int alt30=2;
            	        int LA30_0 = input.LA(1);

            	        if ( (LA30_0==Pluginslots||LA30_0==Implements||LA30_0==Parameter||LA30_0==Multiple||LA30_0==Plugins||(LA30_0>=Format && LA30_0<=Library)||(LA30_0>=Base && LA30_0<=Class)||(LA30_0>=RULE_ID && LA30_0<=RULE_STRING)) ) {
            	            alt30=1;
            	        }


            	        switch (alt30) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1294:6: (lv_actionserver_20_0= ruleActionServer )
            	    	    {
            	    	    // InternalRos1Parser.g:1294:6: (lv_actionserver_20_0= ruleActionServer )
            	    	    // InternalRos1Parser.g:1295:7: lv_actionserver_20_0= ruleActionServer
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getActionserverActionServerParserRuleCall_2_4_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_34);
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
            	    	    break loop30;
            	        }
            	    } while (true);

            	    this_END_21=(Token)match(input,RULE_END,FOLLOW_33); 

            	    					newLeafNode(this_END_21, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_4_3());
            	    				

            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalRos1Parser.g:1318:4: (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1318:4: (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END )
            	    // InternalRos1Parser.g:1319:5: otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END
            	    {
            	    otherlv_22=(Token)match(input,Actionclients,FOLLOW_4); 

            	    					newLeafNode(otherlv_22, grammarAccess.getNodeAccess().getActionclientsKeyword_2_5_0());
            	    				
            	    this_BEGIN_23=(Token)match(input,RULE_BEGIN,FOLLOW_34); 

            	    					newLeafNode(this_BEGIN_23, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_5_1());
            	    				
            	    // InternalRos1Parser.g:1327:5: ( (lv_actionclient_24_0= ruleActionClient ) )*
            	    loop31:
            	    do {
            	        int alt31=2;
            	        int LA31_0 = input.LA(1);

            	        if ( (LA31_0==Pluginslots||LA31_0==Implements||LA31_0==Parameter||LA31_0==Multiple||LA31_0==Plugins||(LA31_0>=Format && LA31_0<=Library)||(LA31_0>=Base && LA31_0<=Class)||(LA31_0>=RULE_ID && LA31_0<=RULE_STRING)) ) {
            	            alt31=1;
            	        }


            	        switch (alt31) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1328:6: (lv_actionclient_24_0= ruleActionClient )
            	    	    {
            	    	    // InternalRos1Parser.g:1328:6: (lv_actionclient_24_0= ruleActionClient )
            	    	    // InternalRos1Parser.g:1329:7: lv_actionclient_24_0= ruleActionClient
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getActionclientActionClientParserRuleCall_2_5_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_34);
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
            	    	    break loop31;
            	        }
            	    } while (true);

            	    this_END_25=(Token)match(input,RULE_END,FOLLOW_33); 

            	    					newLeafNode(this_END_25, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_5_3());
            	    				

            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalRos1Parser.g:1352:4: (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1352:4: (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END )
            	    // InternalRos1Parser.g:1353:5: otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END
            	    {
            	    otherlv_26=(Token)match(input,Parameters,FOLLOW_4); 

            	    					newLeafNode(otherlv_26, grammarAccess.getNodeAccess().getParametersKeyword_2_6_0());
            	    				
            	    this_BEGIN_27=(Token)match(input,RULE_BEGIN,FOLLOW_34); 

            	    					newLeafNode(this_BEGIN_27, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_6_1());
            	    				
            	    // InternalRos1Parser.g:1361:5: ( (lv_parameter_28_0= ruleParameter ) )*
            	    loop32:
            	    do {
            	        int alt32=2;
            	        int LA32_0 = input.LA(1);

            	        if ( (LA32_0==Pluginslots||LA32_0==Implements||LA32_0==Parameter||LA32_0==Multiple||LA32_0==Plugins||(LA32_0>=Format && LA32_0<=Library)||(LA32_0>=Base && LA32_0<=Class)||(LA32_0>=RULE_ID && LA32_0<=RULE_STRING)) ) {
            	            alt32=1;
            	        }


            	        switch (alt32) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1362:6: (lv_parameter_28_0= ruleParameter )
            	    	    {
            	    	    // InternalRos1Parser.g:1362:6: (lv_parameter_28_0= ruleParameter )
            	    	    // InternalRos1Parser.g:1363:7: lv_parameter_28_0= ruleParameter
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getParameterParameterParserRuleCall_2_6_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_34);
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
            	    	    break loop32;
            	        }
            	    } while (true);

            	    this_END_29=(Token)match(input,RULE_END,FOLLOW_33); 

            	    					newLeafNode(this_END_29, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_6_3());
            	    				

            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalRos1Parser.g:1386:4: (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1386:4: (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END )
            	    // InternalRos1Parser.g:1387:5: otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END
            	    {
            	    otherlv_30=(Token)match(input,Pluginslots,FOLLOW_4); 

            	    					newLeafNode(otherlv_30, grammarAccess.getNodeAccess().getPluginslotsKeyword_2_7_0());
            	    				
            	    this_BEGIN_31=(Token)match(input,RULE_BEGIN,FOLLOW_34); 

            	    					newLeafNode(this_BEGIN_31, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_7_1());
            	    				
            	    // InternalRos1Parser.g:1395:5: ( (lv_pluginSlots_32_0= rulePluginSlot ) )*
            	    loop33:
            	    do {
            	        int alt33=2;
            	        int LA33_0 = input.LA(1);

            	        if ( (LA33_0==Pluginslots||LA33_0==Implements||LA33_0==Parameter||LA33_0==Multiple||LA33_0==Plugins||(LA33_0>=Format && LA33_0<=Library)||(LA33_0>=Base && LA33_0<=Class)||(LA33_0>=RULE_ID && LA33_0<=RULE_STRING)) ) {
            	            alt33=1;
            	        }


            	        switch (alt33) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1396:6: (lv_pluginSlots_32_0= rulePluginSlot )
            	    	    {
            	    	    // InternalRos1Parser.g:1396:6: (lv_pluginSlots_32_0= rulePluginSlot )
            	    	    // InternalRos1Parser.g:1397:7: lv_pluginSlots_32_0= rulePluginSlot
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getPluginSlotsPluginSlotParserRuleCall_2_7_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_34);
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
            	    	    break loop33;
            	        }
            	    } while (true);

            	    this_END_33=(Token)match(input,RULE_END,FOLLOW_33); 

            	    					newLeafNode(this_END_33, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_7_3());
            	    				

            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalRos1Parser.g:1420:4: ( (lv_extensions_34_0= ruleExtensionBlock ) )
            	    {
            	    // InternalRos1Parser.g:1420:4: ( (lv_extensions_34_0= ruleExtensionBlock ) )
            	    // InternalRos1Parser.g:1421:5: (lv_extensions_34_0= ruleExtensionBlock )
            	    {
            	    // InternalRos1Parser.g:1421:5: (lv_extensions_34_0= ruleExtensionBlock )
            	    // InternalRos1Parser.g:1422:6: lv_extensions_34_0= ruleExtensionBlock
            	    {

            	    						newCompositeNode(grammarAccess.getNodeAccess().getExtensionsExtensionBlockParserRuleCall_2_8_0());
            	    					
            	    pushFollow(FOLLOW_33);
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
            	    break loop34;
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
    // InternalRos1Parser.g:1444:1: entryRulePlugin returns [EObject current=null] : iv_rulePlugin= rulePlugin EOF ;
    public final EObject entryRulePlugin() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlugin = null;


        try {
            // InternalRos1Parser.g:1444:47: (iv_rulePlugin= rulePlugin EOF )
            // InternalRos1Parser.g:1445:2: iv_rulePlugin= rulePlugin EOF
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
    // InternalRos1Parser.g:1451:1: rulePlugin returns [EObject current=null] : ( () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Implements ( ( ruleQualifiedRef ) ) ( (otherlv_7= Publishers this_BEGIN_8= RULE_BEGIN ( (lv_publisher_9_0= rulePublisher ) )* this_END_10= RULE_END ) | (otherlv_11= Subscribers this_BEGIN_12= RULE_BEGIN ( (lv_subscriber_13_0= ruleSubscriber ) )* this_END_14= RULE_END ) | (otherlv_15= Serviceservers this_BEGIN_16= RULE_BEGIN ( (lv_serviceserver_17_0= ruleServiceServer ) )* this_END_18= RULE_END ) | (otherlv_19= Serviceclients this_BEGIN_20= RULE_BEGIN ( (lv_serviceclient_21_0= ruleServiceClient ) )* this_END_22= RULE_END ) | (otherlv_23= Actionservers this_BEGIN_24= RULE_BEGIN ( (lv_actionserver_25_0= ruleActionServer ) )* this_END_26= RULE_END ) | (otherlv_27= Actionclients this_BEGIN_28= RULE_BEGIN ( (lv_actionclient_29_0= ruleActionClient ) )* this_END_30= RULE_END ) | (otherlv_31= Parameters this_BEGIN_32= RULE_BEGIN ( (lv_parameter_33_0= ruleParameter ) )* this_END_34= RULE_END ) | ( (lv_extensions_35_0= ruleExtensionBlock ) ) )* this_END_36= RULE_END ) ;
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
            // InternalRos1Parser.g:1457:2: ( ( () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Implements ( ( ruleQualifiedRef ) ) ( (otherlv_7= Publishers this_BEGIN_8= RULE_BEGIN ( (lv_publisher_9_0= rulePublisher ) )* this_END_10= RULE_END ) | (otherlv_11= Subscribers this_BEGIN_12= RULE_BEGIN ( (lv_subscriber_13_0= ruleSubscriber ) )* this_END_14= RULE_END ) | (otherlv_15= Serviceservers this_BEGIN_16= RULE_BEGIN ( (lv_serviceserver_17_0= ruleServiceServer ) )* this_END_18= RULE_END ) | (otherlv_19= Serviceclients this_BEGIN_20= RULE_BEGIN ( (lv_serviceclient_21_0= ruleServiceClient ) )* this_END_22= RULE_END ) | (otherlv_23= Actionservers this_BEGIN_24= RULE_BEGIN ( (lv_actionserver_25_0= ruleActionServer ) )* this_END_26= RULE_END ) | (otherlv_27= Actionclients this_BEGIN_28= RULE_BEGIN ( (lv_actionclient_29_0= ruleActionClient ) )* this_END_30= RULE_END ) | (otherlv_31= Parameters this_BEGIN_32= RULE_BEGIN ( (lv_parameter_33_0= ruleParameter ) )* this_END_34= RULE_END ) | ( (lv_extensions_35_0= ruleExtensionBlock ) ) )* this_END_36= RULE_END ) )
            // InternalRos1Parser.g:1458:2: ( () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Implements ( ( ruleQualifiedRef ) ) ( (otherlv_7= Publishers this_BEGIN_8= RULE_BEGIN ( (lv_publisher_9_0= rulePublisher ) )* this_END_10= RULE_END ) | (otherlv_11= Subscribers this_BEGIN_12= RULE_BEGIN ( (lv_subscriber_13_0= ruleSubscriber ) )* this_END_14= RULE_END ) | (otherlv_15= Serviceservers this_BEGIN_16= RULE_BEGIN ( (lv_serviceserver_17_0= ruleServiceServer ) )* this_END_18= RULE_END ) | (otherlv_19= Serviceclients this_BEGIN_20= RULE_BEGIN ( (lv_serviceclient_21_0= ruleServiceClient ) )* this_END_22= RULE_END ) | (otherlv_23= Actionservers this_BEGIN_24= RULE_BEGIN ( (lv_actionserver_25_0= ruleActionServer ) )* this_END_26= RULE_END ) | (otherlv_27= Actionclients this_BEGIN_28= RULE_BEGIN ( (lv_actionclient_29_0= ruleActionClient ) )* this_END_30= RULE_END ) | (otherlv_31= Parameters this_BEGIN_32= RULE_BEGIN ( (lv_parameter_33_0= ruleParameter ) )* this_END_34= RULE_END ) | ( (lv_extensions_35_0= ruleExtensionBlock ) ) )* this_END_36= RULE_END )
            {
            // InternalRos1Parser.g:1458:2: ( () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Implements ( ( ruleQualifiedRef ) ) ( (otherlv_7= Publishers this_BEGIN_8= RULE_BEGIN ( (lv_publisher_9_0= rulePublisher ) )* this_END_10= RULE_END ) | (otherlv_11= Subscribers this_BEGIN_12= RULE_BEGIN ( (lv_subscriber_13_0= ruleSubscriber ) )* this_END_14= RULE_END ) | (otherlv_15= Serviceservers this_BEGIN_16= RULE_BEGIN ( (lv_serviceserver_17_0= ruleServiceServer ) )* this_END_18= RULE_END ) | (otherlv_19= Serviceclients this_BEGIN_20= RULE_BEGIN ( (lv_serviceclient_21_0= ruleServiceClient ) )* this_END_22= RULE_END ) | (otherlv_23= Actionservers this_BEGIN_24= RULE_BEGIN ( (lv_actionserver_25_0= ruleActionServer ) )* this_END_26= RULE_END ) | (otherlv_27= Actionclients this_BEGIN_28= RULE_BEGIN ( (lv_actionclient_29_0= ruleActionClient ) )* this_END_30= RULE_END ) | (otherlv_31= Parameters this_BEGIN_32= RULE_BEGIN ( (lv_parameter_33_0= ruleParameter ) )* this_END_34= RULE_END ) | ( (lv_extensions_35_0= ruleExtensionBlock ) ) )* this_END_36= RULE_END )
            // InternalRos1Parser.g:1459:3: () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Implements ( ( ruleQualifiedRef ) ) ( (otherlv_7= Publishers this_BEGIN_8= RULE_BEGIN ( (lv_publisher_9_0= rulePublisher ) )* this_END_10= RULE_END ) | (otherlv_11= Subscribers this_BEGIN_12= RULE_BEGIN ( (lv_subscriber_13_0= ruleSubscriber ) )* this_END_14= RULE_END ) | (otherlv_15= Serviceservers this_BEGIN_16= RULE_BEGIN ( (lv_serviceserver_17_0= ruleServiceServer ) )* this_END_18= RULE_END ) | (otherlv_19= Serviceclients this_BEGIN_20= RULE_BEGIN ( (lv_serviceclient_21_0= ruleServiceClient ) )* this_END_22= RULE_END ) | (otherlv_23= Actionservers this_BEGIN_24= RULE_BEGIN ( (lv_actionserver_25_0= ruleActionServer ) )* this_END_26= RULE_END ) | (otherlv_27= Actionclients this_BEGIN_28= RULE_BEGIN ( (lv_actionclient_29_0= ruleActionClient ) )* this_END_30= RULE_END ) | (otherlv_31= Parameters this_BEGIN_32= RULE_BEGIN ( (lv_parameter_33_0= ruleParameter ) )* this_END_34= RULE_END ) | ( (lv_extensions_35_0= ruleExtensionBlock ) ) )* this_END_36= RULE_END
            {
            // InternalRos1Parser.g:1459:3: ()
            // InternalRos1Parser.g:1460:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPluginAccess().getPluginAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:1466:3: ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==Library||LA35_0==Class||LA35_0==Node||LA35_0==RULE_ID||LA35_0==RULE_ROS_CONVENTION_A) ) {
                alt35=1;
            }
            else if ( (LA35_0==Pluginslots||LA35_0==Implements||LA35_0==Parameter||LA35_0==Multiple||LA35_0==Plugins||LA35_0==Format||LA35_0==Base) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // InternalRos1Parser.g:1467:4: ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon )
                    {
                    // InternalRos1Parser.g:1467:4: ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon )
                    // InternalRos1Parser.g:1468:5: ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon
                    {
                    // InternalRos1Parser.g:1468:5: ( (lv_name_1_0= ruleRosNames ) )
                    // InternalRos1Parser.g:1469:6: (lv_name_1_0= ruleRosNames )
                    {
                    // InternalRos1Parser.g:1469:6: (lv_name_1_0= ruleRosNames )
                    // InternalRos1Parser.g:1470:7: lv_name_1_0= ruleRosNames
                    {

                    							newCompositeNode(grammarAccess.getPluginAccess().getNameRosNamesParserRuleCall_1_0_0_0());
                    						
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

                    					newLeafNode(otherlv_2, grammarAccess.getPluginAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:1493:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRos1Parser.g:1493:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRos1Parser.g:1494:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRos1Parser.g:1494:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRos1Parser.g:1495:6: lv_name_3_0= ruleAddedKeywordName
                    {

                    						newCompositeNode(grammarAccess.getPluginAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_4);
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

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_35); 

            			newLeafNode(this_BEGIN_4, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_2());
            		
            otherlv_5=(Token)match(input,Implements,FOLLOW_36); 

            			newLeafNode(otherlv_5, grammarAccess.getPluginAccess().getImplementsKeyword_3());
            		
            // InternalRos1Parser.g:1521:3: ( ( ruleQualifiedRef ) )
            // InternalRos1Parser.g:1522:4: ( ruleQualifiedRef )
            {
            // InternalRos1Parser.g:1522:4: ( ruleQualifiedRef )
            // InternalRos1Parser.g:1523:5: ruleQualifiedRef
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPluginRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPluginAccess().getImplementsPluginBaseCrossReference_4_0());
            				
            pushFollow(FOLLOW_37);
            ruleQualifiedRef();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos1Parser.g:1537:3: ( (otherlv_7= Publishers this_BEGIN_8= RULE_BEGIN ( (lv_publisher_9_0= rulePublisher ) )* this_END_10= RULE_END ) | (otherlv_11= Subscribers this_BEGIN_12= RULE_BEGIN ( (lv_subscriber_13_0= ruleSubscriber ) )* this_END_14= RULE_END ) | (otherlv_15= Serviceservers this_BEGIN_16= RULE_BEGIN ( (lv_serviceserver_17_0= ruleServiceServer ) )* this_END_18= RULE_END ) | (otherlv_19= Serviceclients this_BEGIN_20= RULE_BEGIN ( (lv_serviceclient_21_0= ruleServiceClient ) )* this_END_22= RULE_END ) | (otherlv_23= Actionservers this_BEGIN_24= RULE_BEGIN ( (lv_actionserver_25_0= ruleActionServer ) )* this_END_26= RULE_END ) | (otherlv_27= Actionclients this_BEGIN_28= RULE_BEGIN ( (lv_actionclient_29_0= ruleActionClient ) )* this_END_30= RULE_END ) | (otherlv_31= Parameters this_BEGIN_32= RULE_BEGIN ( (lv_parameter_33_0= ruleParameter ) )* this_END_34= RULE_END ) | ( (lv_extensions_35_0= ruleExtensionBlock ) ) )*
            loop43:
            do {
                int alt43=9;
                switch ( input.LA(1) ) {
                case Publishers:
                    {
                    alt43=1;
                    }
                    break;
                case Subscribers:
                    {
                    alt43=2;
                    }
                    break;
                case Serviceservers:
                    {
                    alt43=3;
                    }
                    break;
                case Serviceclients:
                    {
                    alt43=4;
                    }
                    break;
                case Actionservers:
                    {
                    alt43=5;
                    }
                    break;
                case Actionclients:
                    {
                    alt43=6;
                    }
                    break;
                case Parameters:
                    {
                    alt43=7;
                    }
                    break;
                case CommercialAt:
                    {
                    alt43=8;
                    }
                    break;

                }

                switch (alt43) {
            	case 1 :
            	    // InternalRos1Parser.g:1538:4: (otherlv_7= Publishers this_BEGIN_8= RULE_BEGIN ( (lv_publisher_9_0= rulePublisher ) )* this_END_10= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1538:4: (otherlv_7= Publishers this_BEGIN_8= RULE_BEGIN ( (lv_publisher_9_0= rulePublisher ) )* this_END_10= RULE_END )
            	    // InternalRos1Parser.g:1539:5: otherlv_7= Publishers this_BEGIN_8= RULE_BEGIN ( (lv_publisher_9_0= rulePublisher ) )* this_END_10= RULE_END
            	    {
            	    otherlv_7=(Token)match(input,Publishers,FOLLOW_4); 

            	    					newLeafNode(otherlv_7, grammarAccess.getPluginAccess().getPublishersKeyword_5_0_0());
            	    				
            	    this_BEGIN_8=(Token)match(input,RULE_BEGIN,FOLLOW_34); 

            	    					newLeafNode(this_BEGIN_8, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_5_0_1());
            	    				
            	    // InternalRos1Parser.g:1547:5: ( (lv_publisher_9_0= rulePublisher ) )*
            	    loop36:
            	    do {
            	        int alt36=2;
            	        int LA36_0 = input.LA(1);

            	        if ( (LA36_0==Pluginslots||LA36_0==Implements||LA36_0==Parameter||LA36_0==Multiple||LA36_0==Plugins||(LA36_0>=Format && LA36_0<=Library)||(LA36_0>=Base && LA36_0<=Class)||(LA36_0>=RULE_ID && LA36_0<=RULE_STRING)) ) {
            	            alt36=1;
            	        }


            	        switch (alt36) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1548:6: (lv_publisher_9_0= rulePublisher )
            	    	    {
            	    	    // InternalRos1Parser.g:1548:6: (lv_publisher_9_0= rulePublisher )
            	    	    // InternalRos1Parser.g:1549:7: lv_publisher_9_0= rulePublisher
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getPublisherPublisherParserRuleCall_5_0_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_34);
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
            	    	    break loop36;
            	        }
            	    } while (true);

            	    this_END_10=(Token)match(input,RULE_END,FOLLOW_37); 

            	    					newLeafNode(this_END_10, grammarAccess.getPluginAccess().getENDTerminalRuleCall_5_0_3());
            	    				

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRos1Parser.g:1572:4: (otherlv_11= Subscribers this_BEGIN_12= RULE_BEGIN ( (lv_subscriber_13_0= ruleSubscriber ) )* this_END_14= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1572:4: (otherlv_11= Subscribers this_BEGIN_12= RULE_BEGIN ( (lv_subscriber_13_0= ruleSubscriber ) )* this_END_14= RULE_END )
            	    // InternalRos1Parser.g:1573:5: otherlv_11= Subscribers this_BEGIN_12= RULE_BEGIN ( (lv_subscriber_13_0= ruleSubscriber ) )* this_END_14= RULE_END
            	    {
            	    otherlv_11=(Token)match(input,Subscribers,FOLLOW_4); 

            	    					newLeafNode(otherlv_11, grammarAccess.getPluginAccess().getSubscribersKeyword_5_1_0());
            	    				
            	    this_BEGIN_12=(Token)match(input,RULE_BEGIN,FOLLOW_34); 

            	    					newLeafNode(this_BEGIN_12, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_5_1_1());
            	    				
            	    // InternalRos1Parser.g:1581:5: ( (lv_subscriber_13_0= ruleSubscriber ) )*
            	    loop37:
            	    do {
            	        int alt37=2;
            	        int LA37_0 = input.LA(1);

            	        if ( (LA37_0==Pluginslots||LA37_0==Implements||LA37_0==Parameter||LA37_0==Multiple||LA37_0==Plugins||(LA37_0>=Format && LA37_0<=Library)||(LA37_0>=Base && LA37_0<=Class)||(LA37_0>=RULE_ID && LA37_0<=RULE_STRING)) ) {
            	            alt37=1;
            	        }


            	        switch (alt37) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1582:6: (lv_subscriber_13_0= ruleSubscriber )
            	    	    {
            	    	    // InternalRos1Parser.g:1582:6: (lv_subscriber_13_0= ruleSubscriber )
            	    	    // InternalRos1Parser.g:1583:7: lv_subscriber_13_0= ruleSubscriber
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getSubscriberSubscriberParserRuleCall_5_1_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_34);
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
            	    	    break loop37;
            	        }
            	    } while (true);

            	    this_END_14=(Token)match(input,RULE_END,FOLLOW_37); 

            	    					newLeafNode(this_END_14, grammarAccess.getPluginAccess().getENDTerminalRuleCall_5_1_3());
            	    				

            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRos1Parser.g:1606:4: (otherlv_15= Serviceservers this_BEGIN_16= RULE_BEGIN ( (lv_serviceserver_17_0= ruleServiceServer ) )* this_END_18= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1606:4: (otherlv_15= Serviceservers this_BEGIN_16= RULE_BEGIN ( (lv_serviceserver_17_0= ruleServiceServer ) )* this_END_18= RULE_END )
            	    // InternalRos1Parser.g:1607:5: otherlv_15= Serviceservers this_BEGIN_16= RULE_BEGIN ( (lv_serviceserver_17_0= ruleServiceServer ) )* this_END_18= RULE_END
            	    {
            	    otherlv_15=(Token)match(input,Serviceservers,FOLLOW_4); 

            	    					newLeafNode(otherlv_15, grammarAccess.getPluginAccess().getServiceserversKeyword_5_2_0());
            	    				
            	    this_BEGIN_16=(Token)match(input,RULE_BEGIN,FOLLOW_34); 

            	    					newLeafNode(this_BEGIN_16, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_5_2_1());
            	    				
            	    // InternalRos1Parser.g:1615:5: ( (lv_serviceserver_17_0= ruleServiceServer ) )*
            	    loop38:
            	    do {
            	        int alt38=2;
            	        int LA38_0 = input.LA(1);

            	        if ( (LA38_0==Pluginslots||LA38_0==Implements||LA38_0==Parameter||LA38_0==Multiple||LA38_0==Plugins||(LA38_0>=Format && LA38_0<=Library)||(LA38_0>=Base && LA38_0<=Class)||(LA38_0>=RULE_ID && LA38_0<=RULE_STRING)) ) {
            	            alt38=1;
            	        }


            	        switch (alt38) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1616:6: (lv_serviceserver_17_0= ruleServiceServer )
            	    	    {
            	    	    // InternalRos1Parser.g:1616:6: (lv_serviceserver_17_0= ruleServiceServer )
            	    	    // InternalRos1Parser.g:1617:7: lv_serviceserver_17_0= ruleServiceServer
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getServiceserverServiceServerParserRuleCall_5_2_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_34);
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
            	    	    break loop38;
            	        }
            	    } while (true);

            	    this_END_18=(Token)match(input,RULE_END,FOLLOW_37); 

            	    					newLeafNode(this_END_18, grammarAccess.getPluginAccess().getENDTerminalRuleCall_5_2_3());
            	    				

            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalRos1Parser.g:1640:4: (otherlv_19= Serviceclients this_BEGIN_20= RULE_BEGIN ( (lv_serviceclient_21_0= ruleServiceClient ) )* this_END_22= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1640:4: (otherlv_19= Serviceclients this_BEGIN_20= RULE_BEGIN ( (lv_serviceclient_21_0= ruleServiceClient ) )* this_END_22= RULE_END )
            	    // InternalRos1Parser.g:1641:5: otherlv_19= Serviceclients this_BEGIN_20= RULE_BEGIN ( (lv_serviceclient_21_0= ruleServiceClient ) )* this_END_22= RULE_END
            	    {
            	    otherlv_19=(Token)match(input,Serviceclients,FOLLOW_4); 

            	    					newLeafNode(otherlv_19, grammarAccess.getPluginAccess().getServiceclientsKeyword_5_3_0());
            	    				
            	    this_BEGIN_20=(Token)match(input,RULE_BEGIN,FOLLOW_34); 

            	    					newLeafNode(this_BEGIN_20, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_5_3_1());
            	    				
            	    // InternalRos1Parser.g:1649:5: ( (lv_serviceclient_21_0= ruleServiceClient ) )*
            	    loop39:
            	    do {
            	        int alt39=2;
            	        int LA39_0 = input.LA(1);

            	        if ( (LA39_0==Pluginslots||LA39_0==Implements||LA39_0==Parameter||LA39_0==Multiple||LA39_0==Plugins||(LA39_0>=Format && LA39_0<=Library)||(LA39_0>=Base && LA39_0<=Class)||(LA39_0>=RULE_ID && LA39_0<=RULE_STRING)) ) {
            	            alt39=1;
            	        }


            	        switch (alt39) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1650:6: (lv_serviceclient_21_0= ruleServiceClient )
            	    	    {
            	    	    // InternalRos1Parser.g:1650:6: (lv_serviceclient_21_0= ruleServiceClient )
            	    	    // InternalRos1Parser.g:1651:7: lv_serviceclient_21_0= ruleServiceClient
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getServiceclientServiceClientParserRuleCall_5_3_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_34);
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
            	    	    break loop39;
            	        }
            	    } while (true);

            	    this_END_22=(Token)match(input,RULE_END,FOLLOW_37); 

            	    					newLeafNode(this_END_22, grammarAccess.getPluginAccess().getENDTerminalRuleCall_5_3_3());
            	    				

            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalRos1Parser.g:1674:4: (otherlv_23= Actionservers this_BEGIN_24= RULE_BEGIN ( (lv_actionserver_25_0= ruleActionServer ) )* this_END_26= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1674:4: (otherlv_23= Actionservers this_BEGIN_24= RULE_BEGIN ( (lv_actionserver_25_0= ruleActionServer ) )* this_END_26= RULE_END )
            	    // InternalRos1Parser.g:1675:5: otherlv_23= Actionservers this_BEGIN_24= RULE_BEGIN ( (lv_actionserver_25_0= ruleActionServer ) )* this_END_26= RULE_END
            	    {
            	    otherlv_23=(Token)match(input,Actionservers,FOLLOW_4); 

            	    					newLeafNode(otherlv_23, grammarAccess.getPluginAccess().getActionserversKeyword_5_4_0());
            	    				
            	    this_BEGIN_24=(Token)match(input,RULE_BEGIN,FOLLOW_34); 

            	    					newLeafNode(this_BEGIN_24, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_5_4_1());
            	    				
            	    // InternalRos1Parser.g:1683:5: ( (lv_actionserver_25_0= ruleActionServer ) )*
            	    loop40:
            	    do {
            	        int alt40=2;
            	        int LA40_0 = input.LA(1);

            	        if ( (LA40_0==Pluginslots||LA40_0==Implements||LA40_0==Parameter||LA40_0==Multiple||LA40_0==Plugins||(LA40_0>=Format && LA40_0<=Library)||(LA40_0>=Base && LA40_0<=Class)||(LA40_0>=RULE_ID && LA40_0<=RULE_STRING)) ) {
            	            alt40=1;
            	        }


            	        switch (alt40) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1684:6: (lv_actionserver_25_0= ruleActionServer )
            	    	    {
            	    	    // InternalRos1Parser.g:1684:6: (lv_actionserver_25_0= ruleActionServer )
            	    	    // InternalRos1Parser.g:1685:7: lv_actionserver_25_0= ruleActionServer
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getActionserverActionServerParserRuleCall_5_4_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_34);
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
            	    	    break loop40;
            	        }
            	    } while (true);

            	    this_END_26=(Token)match(input,RULE_END,FOLLOW_37); 

            	    					newLeafNode(this_END_26, grammarAccess.getPluginAccess().getENDTerminalRuleCall_5_4_3());
            	    				

            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalRos1Parser.g:1708:4: (otherlv_27= Actionclients this_BEGIN_28= RULE_BEGIN ( (lv_actionclient_29_0= ruleActionClient ) )* this_END_30= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1708:4: (otherlv_27= Actionclients this_BEGIN_28= RULE_BEGIN ( (lv_actionclient_29_0= ruleActionClient ) )* this_END_30= RULE_END )
            	    // InternalRos1Parser.g:1709:5: otherlv_27= Actionclients this_BEGIN_28= RULE_BEGIN ( (lv_actionclient_29_0= ruleActionClient ) )* this_END_30= RULE_END
            	    {
            	    otherlv_27=(Token)match(input,Actionclients,FOLLOW_4); 

            	    					newLeafNode(otherlv_27, grammarAccess.getPluginAccess().getActionclientsKeyword_5_5_0());
            	    				
            	    this_BEGIN_28=(Token)match(input,RULE_BEGIN,FOLLOW_34); 

            	    					newLeafNode(this_BEGIN_28, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_5_5_1());
            	    				
            	    // InternalRos1Parser.g:1717:5: ( (lv_actionclient_29_0= ruleActionClient ) )*
            	    loop41:
            	    do {
            	        int alt41=2;
            	        int LA41_0 = input.LA(1);

            	        if ( (LA41_0==Pluginslots||LA41_0==Implements||LA41_0==Parameter||LA41_0==Multiple||LA41_0==Plugins||(LA41_0>=Format && LA41_0<=Library)||(LA41_0>=Base && LA41_0<=Class)||(LA41_0>=RULE_ID && LA41_0<=RULE_STRING)) ) {
            	            alt41=1;
            	        }


            	        switch (alt41) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1718:6: (lv_actionclient_29_0= ruleActionClient )
            	    	    {
            	    	    // InternalRos1Parser.g:1718:6: (lv_actionclient_29_0= ruleActionClient )
            	    	    // InternalRos1Parser.g:1719:7: lv_actionclient_29_0= ruleActionClient
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getActionclientActionClientParserRuleCall_5_5_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_34);
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
            	    	    break loop41;
            	        }
            	    } while (true);

            	    this_END_30=(Token)match(input,RULE_END,FOLLOW_37); 

            	    					newLeafNode(this_END_30, grammarAccess.getPluginAccess().getENDTerminalRuleCall_5_5_3());
            	    				

            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalRos1Parser.g:1742:4: (otherlv_31= Parameters this_BEGIN_32= RULE_BEGIN ( (lv_parameter_33_0= ruleParameter ) )* this_END_34= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1742:4: (otherlv_31= Parameters this_BEGIN_32= RULE_BEGIN ( (lv_parameter_33_0= ruleParameter ) )* this_END_34= RULE_END )
            	    // InternalRos1Parser.g:1743:5: otherlv_31= Parameters this_BEGIN_32= RULE_BEGIN ( (lv_parameter_33_0= ruleParameter ) )* this_END_34= RULE_END
            	    {
            	    otherlv_31=(Token)match(input,Parameters,FOLLOW_4); 

            	    					newLeafNode(otherlv_31, grammarAccess.getPluginAccess().getParametersKeyword_5_6_0());
            	    				
            	    this_BEGIN_32=(Token)match(input,RULE_BEGIN,FOLLOW_34); 

            	    					newLeafNode(this_BEGIN_32, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_5_6_1());
            	    				
            	    // InternalRos1Parser.g:1751:5: ( (lv_parameter_33_0= ruleParameter ) )*
            	    loop42:
            	    do {
            	        int alt42=2;
            	        int LA42_0 = input.LA(1);

            	        if ( (LA42_0==Pluginslots||LA42_0==Implements||LA42_0==Parameter||LA42_0==Multiple||LA42_0==Plugins||(LA42_0>=Format && LA42_0<=Library)||(LA42_0>=Base && LA42_0<=Class)||(LA42_0>=RULE_ID && LA42_0<=RULE_STRING)) ) {
            	            alt42=1;
            	        }


            	        switch (alt42) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1752:6: (lv_parameter_33_0= ruleParameter )
            	    	    {
            	    	    // InternalRos1Parser.g:1752:6: (lv_parameter_33_0= ruleParameter )
            	    	    // InternalRos1Parser.g:1753:7: lv_parameter_33_0= ruleParameter
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getParameterParameterParserRuleCall_5_6_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_34);
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
            	    	    break loop42;
            	        }
            	    } while (true);

            	    this_END_34=(Token)match(input,RULE_END,FOLLOW_37); 

            	    					newLeafNode(this_END_34, grammarAccess.getPluginAccess().getENDTerminalRuleCall_5_6_3());
            	    				

            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalRos1Parser.g:1776:4: ( (lv_extensions_35_0= ruleExtensionBlock ) )
            	    {
            	    // InternalRos1Parser.g:1776:4: ( (lv_extensions_35_0= ruleExtensionBlock ) )
            	    // InternalRos1Parser.g:1777:5: (lv_extensions_35_0= ruleExtensionBlock )
            	    {
            	    // InternalRos1Parser.g:1777:5: (lv_extensions_35_0= ruleExtensionBlock )
            	    // InternalRos1Parser.g:1778:6: lv_extensions_35_0= ruleExtensionBlock
            	    {

            	    						newCompositeNode(grammarAccess.getPluginAccess().getExtensionsExtensionBlockParserRuleCall_5_7_0());
            	    					
            	    pushFollow(FOLLOW_37);
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
            	    break loop43;
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
    // InternalRos1Parser.g:1804:1: entryRulePluginSlot returns [EObject current=null] : iv_rulePluginSlot= rulePluginSlot EOF ;
    public final EObject entryRulePluginSlot() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePluginSlot = null;


        try {
            // InternalRos1Parser.g:1804:51: (iv_rulePluginSlot= rulePluginSlot EOF )
            // InternalRos1Parser.g:1805:2: iv_rulePluginSlot= rulePluginSlot EOF
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
    // InternalRos1Parser.g:1811:1: rulePluginSlot returns [EObject current=null] : ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( (this_BEGIN_4= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?) ) ) this_END_16= RULE_END ) | (otherlv_17= LeftCurlyBracket otherlv_18= Base ( ( ruleQualifiedRef ) ) (otherlv_20= Comma )? otherlv_21= Parameter ( (lv_parameter_22_0= ruleEString ) ) ( (otherlv_23= Comma )? otherlv_24= Format ( (lv_valueFormat_25_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_26= Comma )? otherlv_27= Multiple ( (lv_multiple_28_0= ruleboolean0 ) ) )? ( (otherlv_29= Comma )? otherlv_30= Default ( ( ruleQualifiedRef ) ) )? otherlv_32= RightCurlyBracket ) ) ) ;
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
            // InternalRos1Parser.g:1817:2: ( ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( (this_BEGIN_4= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?) ) ) this_END_16= RULE_END ) | (otherlv_17= LeftCurlyBracket otherlv_18= Base ( ( ruleQualifiedRef ) ) (otherlv_20= Comma )? otherlv_21= Parameter ( (lv_parameter_22_0= ruleEString ) ) ( (otherlv_23= Comma )? otherlv_24= Format ( (lv_valueFormat_25_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_26= Comma )? otherlv_27= Multiple ( (lv_multiple_28_0= ruleboolean0 ) ) )? ( (otherlv_29= Comma )? otherlv_30= Default ( ( ruleQualifiedRef ) ) )? otherlv_32= RightCurlyBracket ) ) ) )
            // InternalRos1Parser.g:1818:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( (this_BEGIN_4= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?) ) ) this_END_16= RULE_END ) | (otherlv_17= LeftCurlyBracket otherlv_18= Base ( ( ruleQualifiedRef ) ) (otherlv_20= Comma )? otherlv_21= Parameter ( (lv_parameter_22_0= ruleEString ) ) ( (otherlv_23= Comma )? otherlv_24= Format ( (lv_valueFormat_25_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_26= Comma )? otherlv_27= Multiple ( (lv_multiple_28_0= ruleboolean0 ) ) )? ( (otherlv_29= Comma )? otherlv_30= Default ( ( ruleQualifiedRef ) ) )? otherlv_32= RightCurlyBracket ) ) )
            {
            // InternalRos1Parser.g:1818:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( (this_BEGIN_4= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?) ) ) this_END_16= RULE_END ) | (otherlv_17= LeftCurlyBracket otherlv_18= Base ( ( ruleQualifiedRef ) ) (otherlv_20= Comma )? otherlv_21= Parameter ( (lv_parameter_22_0= ruleEString ) ) ( (otherlv_23= Comma )? otherlv_24= Format ( (lv_valueFormat_25_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_26= Comma )? otherlv_27= Multiple ( (lv_multiple_28_0= ruleboolean0 ) ) )? ( (otherlv_29= Comma )? otherlv_30= Default ( ( ruleQualifiedRef ) ) )? otherlv_32= RightCurlyBracket ) ) )
            // InternalRos1Parser.g:1819:3: () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( (this_BEGIN_4= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?) ) ) this_END_16= RULE_END ) | (otherlv_17= LeftCurlyBracket otherlv_18= Base ( ( ruleQualifiedRef ) ) (otherlv_20= Comma )? otherlv_21= Parameter ( (lv_parameter_22_0= ruleEString ) ) ( (otherlv_23= Comma )? otherlv_24= Format ( (lv_valueFormat_25_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_26= Comma )? otherlv_27= Multiple ( (lv_multiple_28_0= ruleboolean0 ) ) )? ( (otherlv_29= Comma )? otherlv_30= Default ( ( ruleQualifiedRef ) ) )? otherlv_32= RightCurlyBracket ) )
            {
            // InternalRos1Parser.g:1819:3: ()
            // InternalRos1Parser.g:1820:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPluginSlotAccess().getPluginSlotAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:1826:3: ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==Library||LA44_0==Class||(LA44_0>=RULE_ID && LA44_0<=RULE_STRING)) ) {
                alt44=1;
            }
            else if ( (LA44_0==Pluginslots||LA44_0==Implements||LA44_0==Parameter||LA44_0==Multiple||LA44_0==Plugins||LA44_0==Format||LA44_0==Base) ) {
                alt44=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // InternalRos1Parser.g:1827:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    {
                    // InternalRos1Parser.g:1827:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    // InternalRos1Parser.g:1828:5: ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon
                    {
                    // InternalRos1Parser.g:1828:5: ( (lv_name_1_0= ruleEString ) )
                    // InternalRos1Parser.g:1829:6: (lv_name_1_0= ruleEString )
                    {
                    // InternalRos1Parser.g:1829:6: (lv_name_1_0= ruleEString )
                    // InternalRos1Parser.g:1830:7: lv_name_1_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getPluginSlotAccess().getNameEStringParserRuleCall_1_0_0_0());
                    						
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

                    otherlv_2=(Token)match(input,Colon,FOLLOW_38); 

                    					newLeafNode(otherlv_2, grammarAccess.getPluginSlotAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:1853:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRos1Parser.g:1853:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRos1Parser.g:1854:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRos1Parser.g:1854:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRos1Parser.g:1855:6: lv_name_3_0= ruleAddedKeywordName
                    {

                    						newCompositeNode(grammarAccess.getPluginSlotAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_38);
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

            // InternalRos1Parser.g:1873:3: ( (this_BEGIN_4= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?) ) ) this_END_16= RULE_END ) | (otherlv_17= LeftCurlyBracket otherlv_18= Base ( ( ruleQualifiedRef ) ) (otherlv_20= Comma )? otherlv_21= Parameter ( (lv_parameter_22_0= ruleEString ) ) ( (otherlv_23= Comma )? otherlv_24= Format ( (lv_valueFormat_25_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_26= Comma )? otherlv_27= Multiple ( (lv_multiple_28_0= ruleboolean0 ) ) )? ( (otherlv_29= Comma )? otherlv_30= Default ( ( ruleQualifiedRef ) ) )? otherlv_32= RightCurlyBracket ) )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_BEGIN) ) {
                alt53=1;
            }
            else if ( (LA53_0==LeftCurlyBracket) ) {
                alt53=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // InternalRos1Parser.g:1874:4: (this_BEGIN_4= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?) ) ) this_END_16= RULE_END )
                    {
                    // InternalRos1Parser.g:1874:4: (this_BEGIN_4= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?) ) ) this_END_16= RULE_END )
                    // InternalRos1Parser.g:1875:5: this_BEGIN_4= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?) ) ) this_END_16= RULE_END
                    {
                    this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_39); 

                    					newLeafNode(this_BEGIN_4, grammarAccess.getPluginSlotAccess().getBEGINTerminalRuleCall_2_0_0());
                    				
                    // InternalRos1Parser.g:1879:5: ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?) ) )
                    // InternalRos1Parser.g:1880:6: ( ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?) )
                    {
                    // InternalRos1Parser.g:1880:6: ( ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?) )
                    // InternalRos1Parser.g:1881:7: ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?)
                    {
                     
                    						  getUnorderedGroupHelper().enter(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1());
                    						
                    // InternalRos1Parser.g:1884:7: ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?)
                    // InternalRos1Parser.g:1885:8: ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?
                    {
                    // InternalRos1Parser.g:1885:8: ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+
                    int cnt45=0;
                    loop45:
                    do {
                        int alt45=6;
                        int LA45_0 = input.LA(1);

                        if ( LA45_0 == Base && getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 0) ) {
                            alt45=1;
                        }
                        else if ( LA45_0 == Parameter && getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 1) ) {
                            alt45=2;
                        }
                        else if ( LA45_0 == Format && getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 2) ) {
                            alt45=3;
                        }
                        else if ( LA45_0 == Multiple && getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 3) ) {
                            alt45=4;
                        }
                        else if ( LA45_0 == Default && getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 4) ) {
                            alt45=5;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // InternalRos1Parser.g:1886:6: ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) )
                    	    {
                    	    // InternalRos1Parser.g:1886:6: ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) )
                    	    // InternalRos1Parser.g:1887:7: {...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 0) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 0)");
                    	    }
                    	    // InternalRos1Parser.g:1887:113: ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) )
                    	    // InternalRos1Parser.g:1888:8: ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) )
                    	    {

                    	    								getUnorderedGroupHelper().select(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 0);
                    	    							
                    	    // InternalRos1Parser.g:1891:11: ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) )
                    	    // InternalRos1Parser.g:1891:12: {...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "true");
                    	    }
                    	    // InternalRos1Parser.g:1891:21: (otherlv_6= Base ( ( ruleQualifiedRef ) ) )
                    	    // InternalRos1Parser.g:1891:22: otherlv_6= Base ( ( ruleQualifiedRef ) )
                    	    {
                    	    otherlv_6=(Token)match(input,Base,FOLLOW_36); 

                    	    											newLeafNode(otherlv_6, grammarAccess.getPluginSlotAccess().getBaseKeyword_2_0_1_0_0());
                    	    										
                    	    // InternalRos1Parser.g:1895:11: ( ( ruleQualifiedRef ) )
                    	    // InternalRos1Parser.g:1896:12: ( ruleQualifiedRef )
                    	    {
                    	    // InternalRos1Parser.g:1896:12: ( ruleQualifiedRef )
                    	    // InternalRos1Parser.g:1897:13: ruleQualifiedRef
                    	    {

                    	    													if (current==null) {
                    	    														current = createModelElement(grammarAccess.getPluginSlotRule());
                    	    													}
                    	    												

                    	    													newCompositeNode(grammarAccess.getPluginSlotAccess().getBasePluginBaseCrossReference_2_0_1_0_1_0());
                    	    												
                    	    pushFollow(FOLLOW_40);
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
                    	    // InternalRos1Parser.g:1917:6: ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) )
                    	    {
                    	    // InternalRos1Parser.g:1917:6: ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) )
                    	    // InternalRos1Parser.g:1918:7: {...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 1) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 1)");
                    	    }
                    	    // InternalRos1Parser.g:1918:113: ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) )
                    	    // InternalRos1Parser.g:1919:8: ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) )
                    	    {

                    	    								getUnorderedGroupHelper().select(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 1);
                    	    							
                    	    // InternalRos1Parser.g:1922:11: ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) )
                    	    // InternalRos1Parser.g:1922:12: {...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "true");
                    	    }
                    	    // InternalRos1Parser.g:1922:21: (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) )
                    	    // InternalRos1Parser.g:1922:22: otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) )
                    	    {
                    	    otherlv_8=(Token)match(input,Parameter,FOLLOW_6); 

                    	    											newLeafNode(otherlv_8, grammarAccess.getPluginSlotAccess().getParameterKeyword_2_0_1_1_0());
                    	    										
                    	    // InternalRos1Parser.g:1926:11: ( (lv_parameter_9_0= ruleEString ) )
                    	    // InternalRos1Parser.g:1927:12: (lv_parameter_9_0= ruleEString )
                    	    {
                    	    // InternalRos1Parser.g:1927:12: (lv_parameter_9_0= ruleEString )
                    	    // InternalRos1Parser.g:1928:13: lv_parameter_9_0= ruleEString
                    	    {

                    	    													newCompositeNode(grammarAccess.getPluginSlotAccess().getParameterEStringParserRuleCall_2_0_1_1_1_0());
                    	    												
                    	    pushFollow(FOLLOW_40);
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
                    	    // InternalRos1Parser.g:1951:6: ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) )
                    	    {
                    	    // InternalRos1Parser.g:1951:6: ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) )
                    	    // InternalRos1Parser.g:1952:7: {...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 2) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 2)");
                    	    }
                    	    // InternalRos1Parser.g:1952:113: ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) )
                    	    // InternalRos1Parser.g:1953:8: ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) )
                    	    {

                    	    								getUnorderedGroupHelper().select(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 2);
                    	    							
                    	    // InternalRos1Parser.g:1956:11: ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) )
                    	    // InternalRos1Parser.g:1956:12: {...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "true");
                    	    }
                    	    // InternalRos1Parser.g:1956:21: (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) )
                    	    // InternalRos1Parser.g:1956:22: otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) )
                    	    {
                    	    otherlv_10=(Token)match(input,Format,FOLLOW_41); 

                    	    											newLeafNode(otherlv_10, grammarAccess.getPluginSlotAccess().getFormatKeyword_2_0_1_2_0());
                    	    										
                    	    // InternalRos1Parser.g:1960:11: ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) )
                    	    // InternalRos1Parser.g:1961:12: (lv_valueFormat_11_0= rulePluginSlotValueFormat )
                    	    {
                    	    // InternalRos1Parser.g:1961:12: (lv_valueFormat_11_0= rulePluginSlotValueFormat )
                    	    // InternalRos1Parser.g:1962:13: lv_valueFormat_11_0= rulePluginSlotValueFormat
                    	    {

                    	    													newCompositeNode(grammarAccess.getPluginSlotAccess().getValueFormatPluginSlotValueFormatEnumRuleCall_2_0_1_2_1_0());
                    	    												
                    	    pushFollow(FOLLOW_40);
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
                    	    // InternalRos1Parser.g:1985:6: ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) )
                    	    {
                    	    // InternalRos1Parser.g:1985:6: ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) )
                    	    // InternalRos1Parser.g:1986:7: {...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 3) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 3)");
                    	    }
                    	    // InternalRos1Parser.g:1986:113: ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) )
                    	    // InternalRos1Parser.g:1987:8: ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) )
                    	    {

                    	    								getUnorderedGroupHelper().select(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 3);
                    	    							
                    	    // InternalRos1Parser.g:1990:11: ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) )
                    	    // InternalRos1Parser.g:1990:12: {...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "true");
                    	    }
                    	    // InternalRos1Parser.g:1990:21: (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) )
                    	    // InternalRos1Parser.g:1990:22: otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) )
                    	    {
                    	    otherlv_12=(Token)match(input,Multiple,FOLLOW_42); 

                    	    											newLeafNode(otherlv_12, grammarAccess.getPluginSlotAccess().getMultipleKeyword_2_0_1_3_0());
                    	    										
                    	    // InternalRos1Parser.g:1994:11: ( (lv_multiple_13_0= ruleboolean0 ) )
                    	    // InternalRos1Parser.g:1995:12: (lv_multiple_13_0= ruleboolean0 )
                    	    {
                    	    // InternalRos1Parser.g:1995:12: (lv_multiple_13_0= ruleboolean0 )
                    	    // InternalRos1Parser.g:1996:13: lv_multiple_13_0= ruleboolean0
                    	    {

                    	    													newCompositeNode(grammarAccess.getPluginSlotAccess().getMultipleBoolean0ParserRuleCall_2_0_1_3_1_0());
                    	    												
                    	    pushFollow(FOLLOW_40);
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
                    	    // InternalRos1Parser.g:2019:6: ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) )
                    	    {
                    	    // InternalRos1Parser.g:2019:6: ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) )
                    	    // InternalRos1Parser.g:2020:7: {...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 4) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 4)");
                    	    }
                    	    // InternalRos1Parser.g:2020:113: ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) )
                    	    // InternalRos1Parser.g:2021:8: ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) )
                    	    {

                    	    								getUnorderedGroupHelper().select(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 4);
                    	    							
                    	    // InternalRos1Parser.g:2024:11: ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) )
                    	    // InternalRos1Parser.g:2024:12: {...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "true");
                    	    }
                    	    // InternalRos1Parser.g:2024:21: (otherlv_14= Default ( ( ruleQualifiedRef ) ) )
                    	    // InternalRos1Parser.g:2024:22: otherlv_14= Default ( ( ruleQualifiedRef ) )
                    	    {
                    	    otherlv_14=(Token)match(input,Default,FOLLOW_36); 

                    	    											newLeafNode(otherlv_14, grammarAccess.getPluginSlotAccess().getDefaultKeyword_2_0_1_4_0());
                    	    										
                    	    // InternalRos1Parser.g:2028:11: ( ( ruleQualifiedRef ) )
                    	    // InternalRos1Parser.g:2029:12: ( ruleQualifiedRef )
                    	    {
                    	    // InternalRos1Parser.g:2029:12: ( ruleQualifiedRef )
                    	    // InternalRos1Parser.g:2030:13: ruleQualifiedRef
                    	    {

                    	    													if (current==null) {
                    	    														current = createModelElement(grammarAccess.getPluginSlotRule());
                    	    													}
                    	    												

                    	    													newCompositeNode(grammarAccess.getPluginSlotAccess().getDefaultPluginPluginCrossReference_2_0_1_4_1_0());
                    	    												
                    	    pushFollow(FOLLOW_40);
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
                    	    if ( cnt45 >= 1 ) break loop45;
                                EarlyExitException eee =
                                    new EarlyExitException(45, input);
                                throw eee;
                        }
                        cnt45++;
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
                    // InternalRos1Parser.g:2064:4: (otherlv_17= LeftCurlyBracket otherlv_18= Base ( ( ruleQualifiedRef ) ) (otherlv_20= Comma )? otherlv_21= Parameter ( (lv_parameter_22_0= ruleEString ) ) ( (otherlv_23= Comma )? otherlv_24= Format ( (lv_valueFormat_25_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_26= Comma )? otherlv_27= Multiple ( (lv_multiple_28_0= ruleboolean0 ) ) )? ( (otherlv_29= Comma )? otherlv_30= Default ( ( ruleQualifiedRef ) ) )? otherlv_32= RightCurlyBracket )
                    {
                    // InternalRos1Parser.g:2064:4: (otherlv_17= LeftCurlyBracket otherlv_18= Base ( ( ruleQualifiedRef ) ) (otherlv_20= Comma )? otherlv_21= Parameter ( (lv_parameter_22_0= ruleEString ) ) ( (otherlv_23= Comma )? otherlv_24= Format ( (lv_valueFormat_25_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_26= Comma )? otherlv_27= Multiple ( (lv_multiple_28_0= ruleboolean0 ) ) )? ( (otherlv_29= Comma )? otherlv_30= Default ( ( ruleQualifiedRef ) ) )? otherlv_32= RightCurlyBracket )
                    // InternalRos1Parser.g:2065:5: otherlv_17= LeftCurlyBracket otherlv_18= Base ( ( ruleQualifiedRef ) ) (otherlv_20= Comma )? otherlv_21= Parameter ( (lv_parameter_22_0= ruleEString ) ) ( (otherlv_23= Comma )? otherlv_24= Format ( (lv_valueFormat_25_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_26= Comma )? otherlv_27= Multiple ( (lv_multiple_28_0= ruleboolean0 ) ) )? ( (otherlv_29= Comma )? otherlv_30= Default ( ( ruleQualifiedRef ) ) )? otherlv_32= RightCurlyBracket
                    {
                    otherlv_17=(Token)match(input,LeftCurlyBracket,FOLLOW_43); 

                    					newLeafNode(otherlv_17, grammarAccess.getPluginSlotAccess().getLeftCurlyBracketKeyword_2_1_0());
                    				
                    otherlv_18=(Token)match(input,Base,FOLLOW_36); 

                    					newLeafNode(otherlv_18, grammarAccess.getPluginSlotAccess().getBaseKeyword_2_1_1());
                    				
                    // InternalRos1Parser.g:2073:5: ( ( ruleQualifiedRef ) )
                    // InternalRos1Parser.g:2074:6: ( ruleQualifiedRef )
                    {
                    // InternalRos1Parser.g:2074:6: ( ruleQualifiedRef )
                    // InternalRos1Parser.g:2075:7: ruleQualifiedRef
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getPluginSlotRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getPluginSlotAccess().getBasePluginBaseCrossReference_2_1_2_0());
                    						
                    pushFollow(FOLLOW_44);
                    ruleQualifiedRef();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalRos1Parser.g:2089:5: (otherlv_20= Comma )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==Comma) ) {
                        alt46=1;
                    }
                    switch (alt46) {
                        case 1 :
                            // InternalRos1Parser.g:2090:6: otherlv_20= Comma
                            {
                            otherlv_20=(Token)match(input,Comma,FOLLOW_45); 

                            						newLeafNode(otherlv_20, grammarAccess.getPluginSlotAccess().getCommaKeyword_2_1_3());
                            					

                            }
                            break;

                    }

                    otherlv_21=(Token)match(input,Parameter,FOLLOW_6); 

                    					newLeafNode(otherlv_21, grammarAccess.getPluginSlotAccess().getParameterKeyword_2_1_4());
                    				
                    // InternalRos1Parser.g:2099:5: ( (lv_parameter_22_0= ruleEString ) )
                    // InternalRos1Parser.g:2100:6: (lv_parameter_22_0= ruleEString )
                    {
                    // InternalRos1Parser.g:2100:6: (lv_parameter_22_0= ruleEString )
                    // InternalRos1Parser.g:2101:7: lv_parameter_22_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getPluginSlotAccess().getParameterEStringParserRuleCall_2_1_5_0());
                    						
                    pushFollow(FOLLOW_46);
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

                    // InternalRos1Parser.g:2118:5: ( (otherlv_23= Comma )? otherlv_24= Format ( (lv_valueFormat_25_0= rulePluginSlotValueFormat ) ) )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==Comma) ) {
                        int LA48_1 = input.LA(2);

                        if ( (LA48_1==Format) ) {
                            alt48=1;
                        }
                    }
                    else if ( (LA48_0==Format) ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            // InternalRos1Parser.g:2119:6: (otherlv_23= Comma )? otherlv_24= Format ( (lv_valueFormat_25_0= rulePluginSlotValueFormat ) )
                            {
                            // InternalRos1Parser.g:2119:6: (otherlv_23= Comma )?
                            int alt47=2;
                            int LA47_0 = input.LA(1);

                            if ( (LA47_0==Comma) ) {
                                alt47=1;
                            }
                            switch (alt47) {
                                case 1 :
                                    // InternalRos1Parser.g:2120:7: otherlv_23= Comma
                                    {
                                    otherlv_23=(Token)match(input,Comma,FOLLOW_47); 

                                    							newLeafNode(otherlv_23, grammarAccess.getPluginSlotAccess().getCommaKeyword_2_1_6_0());
                                    						

                                    }
                                    break;

                            }

                            otherlv_24=(Token)match(input,Format,FOLLOW_41); 

                            						newLeafNode(otherlv_24, grammarAccess.getPluginSlotAccess().getFormatKeyword_2_1_6_1());
                            					
                            // InternalRos1Parser.g:2129:6: ( (lv_valueFormat_25_0= rulePluginSlotValueFormat ) )
                            // InternalRos1Parser.g:2130:7: (lv_valueFormat_25_0= rulePluginSlotValueFormat )
                            {
                            // InternalRos1Parser.g:2130:7: (lv_valueFormat_25_0= rulePluginSlotValueFormat )
                            // InternalRos1Parser.g:2131:8: lv_valueFormat_25_0= rulePluginSlotValueFormat
                            {

                            								newCompositeNode(grammarAccess.getPluginSlotAccess().getValueFormatPluginSlotValueFormatEnumRuleCall_2_1_6_2_0());
                            							
                            pushFollow(FOLLOW_48);
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

                    // InternalRos1Parser.g:2149:5: ( (otherlv_26= Comma )? otherlv_27= Multiple ( (lv_multiple_28_0= ruleboolean0 ) ) )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==Comma) ) {
                        int LA50_1 = input.LA(2);

                        if ( (LA50_1==Multiple) ) {
                            alt50=1;
                        }
                    }
                    else if ( (LA50_0==Multiple) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // InternalRos1Parser.g:2150:6: (otherlv_26= Comma )? otherlv_27= Multiple ( (lv_multiple_28_0= ruleboolean0 ) )
                            {
                            // InternalRos1Parser.g:2150:6: (otherlv_26= Comma )?
                            int alt49=2;
                            int LA49_0 = input.LA(1);

                            if ( (LA49_0==Comma) ) {
                                alt49=1;
                            }
                            switch (alt49) {
                                case 1 :
                                    // InternalRos1Parser.g:2151:7: otherlv_26= Comma
                                    {
                                    otherlv_26=(Token)match(input,Comma,FOLLOW_49); 

                                    							newLeafNode(otherlv_26, grammarAccess.getPluginSlotAccess().getCommaKeyword_2_1_7_0());
                                    						

                                    }
                                    break;

                            }

                            otherlv_27=(Token)match(input,Multiple,FOLLOW_42); 

                            						newLeafNode(otherlv_27, grammarAccess.getPluginSlotAccess().getMultipleKeyword_2_1_7_1());
                            					
                            // InternalRos1Parser.g:2160:6: ( (lv_multiple_28_0= ruleboolean0 ) )
                            // InternalRos1Parser.g:2161:7: (lv_multiple_28_0= ruleboolean0 )
                            {
                            // InternalRos1Parser.g:2161:7: (lv_multiple_28_0= ruleboolean0 )
                            // InternalRos1Parser.g:2162:8: lv_multiple_28_0= ruleboolean0
                            {

                            								newCompositeNode(grammarAccess.getPluginSlotAccess().getMultipleBoolean0ParserRuleCall_2_1_7_2_0());
                            							
                            pushFollow(FOLLOW_50);
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

                    // InternalRos1Parser.g:2180:5: ( (otherlv_29= Comma )? otherlv_30= Default ( ( ruleQualifiedRef ) ) )?
                    int alt52=2;
                    int LA52_0 = input.LA(1);

                    if ( (LA52_0==Default||LA52_0==Comma) ) {
                        alt52=1;
                    }
                    switch (alt52) {
                        case 1 :
                            // InternalRos1Parser.g:2181:6: (otherlv_29= Comma )? otherlv_30= Default ( ( ruleQualifiedRef ) )
                            {
                            // InternalRos1Parser.g:2181:6: (otherlv_29= Comma )?
                            int alt51=2;
                            int LA51_0 = input.LA(1);

                            if ( (LA51_0==Comma) ) {
                                alt51=1;
                            }
                            switch (alt51) {
                                case 1 :
                                    // InternalRos1Parser.g:2182:7: otherlv_29= Comma
                                    {
                                    otherlv_29=(Token)match(input,Comma,FOLLOW_51); 

                                    							newLeafNode(otherlv_29, grammarAccess.getPluginSlotAccess().getCommaKeyword_2_1_8_0());
                                    						

                                    }
                                    break;

                            }

                            otherlv_30=(Token)match(input,Default,FOLLOW_36); 

                            						newLeafNode(otherlv_30, grammarAccess.getPluginSlotAccess().getDefaultKeyword_2_1_8_1());
                            					
                            // InternalRos1Parser.g:2191:6: ( ( ruleQualifiedRef ) )
                            // InternalRos1Parser.g:2192:7: ( ruleQualifiedRef )
                            {
                            // InternalRos1Parser.g:2192:7: ( ruleQualifiedRef )
                            // InternalRos1Parser.g:2193:8: ruleQualifiedRef
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getPluginSlotRule());
                            								}
                            							

                            								newCompositeNode(grammarAccess.getPluginSlotAccess().getDefaultPluginPluginCrossReference_2_1_8_2_0());
                            							
                            pushFollow(FOLLOW_52);
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
    // InternalRos1Parser.g:2218:1: entryRuleAddedKeywordName returns [String current=null] : iv_ruleAddedKeywordName= ruleAddedKeywordName EOF ;
    public final String entryRuleAddedKeywordName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAddedKeywordName = null;


        try {
            // InternalRos1Parser.g:2218:56: (iv_ruleAddedKeywordName= ruleAddedKeywordName EOF )
            // InternalRos1Parser.g:2219:2: iv_ruleAddedKeywordName= ruleAddedKeywordName EOF
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
    // InternalRos1Parser.g:2225:1: ruleAddedKeywordName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Plugins | kw= Implements | kw= Pluginslots | kw= Base | kw= Parameter | kw= Format | kw= Multiple ) ;
    public final AntlrDatatypeRuleToken ruleAddedKeywordName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:2231:2: ( (kw= Plugins | kw= Implements | kw= Pluginslots | kw= Base | kw= Parameter | kw= Format | kw= Multiple ) )
            // InternalRos1Parser.g:2232:2: (kw= Plugins | kw= Implements | kw= Pluginslots | kw= Base | kw= Parameter | kw= Format | kw= Multiple )
            {
            // InternalRos1Parser.g:2232:2: (kw= Plugins | kw= Implements | kw= Pluginslots | kw= Base | kw= Parameter | kw= Format | kw= Multiple )
            int alt54=7;
            switch ( input.LA(1) ) {
            case Plugins:
                {
                alt54=1;
                }
                break;
            case Implements:
                {
                alt54=2;
                }
                break;
            case Pluginslots:
                {
                alt54=3;
                }
                break;
            case Base:
                {
                alt54=4;
                }
                break;
            case Parameter:
                {
                alt54=5;
                }
                break;
            case Format:
                {
                alt54=6;
                }
                break;
            case Multiple:
                {
                alt54=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // InternalRos1Parser.g:2233:3: kw= Plugins
                    {
                    kw=(Token)match(input,Plugins,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAddedKeywordNameAccess().getPluginsKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:2239:3: kw= Implements
                    {
                    kw=(Token)match(input,Implements,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAddedKeywordNameAccess().getImplementsKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRos1Parser.g:2245:3: kw= Pluginslots
                    {
                    kw=(Token)match(input,Pluginslots,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAddedKeywordNameAccess().getPluginslotsKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRos1Parser.g:2251:3: kw= Base
                    {
                    kw=(Token)match(input,Base,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAddedKeywordNameAccess().getBaseKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRos1Parser.g:2257:3: kw= Parameter
                    {
                    kw=(Token)match(input,Parameter,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAddedKeywordNameAccess().getParameterKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalRos1Parser.g:2263:3: kw= Format
                    {
                    kw=(Token)match(input,Format,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAddedKeywordNameAccess().getFormatKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalRos1Parser.g:2269:3: kw= Multiple
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
    // InternalRos1Parser.g:2278:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalRos1Parser.g:2278:47: (iv_ruleEString= ruleEString EOF )
            // InternalRos1Parser.g:2279:2: iv_ruleEString= ruleEString EOF
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
    // InternalRos1Parser.g:2285:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | kw= Class | kw= Library ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:2291:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | kw= Class | kw= Library ) )
            // InternalRos1Parser.g:2292:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | kw= Class | kw= Library )
            {
            // InternalRos1Parser.g:2292:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | kw= Class | kw= Library )
            int alt55=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt55=1;
                }
                break;
            case RULE_ID:
                {
                alt55=2;
                }
                break;
            case Class:
                {
                alt55=3;
                }
                break;
            case Library:
                {
                alt55=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // InternalRos1Parser.g:2293:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:2301:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRos1Parser.g:2309:3: kw= Class
                    {
                    kw=(Token)match(input,Class,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEStringAccess().getClassKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRos1Parser.g:2315:3: kw= Library
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
    // InternalRos1Parser.g:2324:1: entryRuleRosNames returns [String current=null] : iv_ruleRosNames= ruleRosNames EOF ;
    public final String entryRuleRosNames() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRosNames = null;


        try {
            // InternalRos1Parser.g:2324:48: (iv_ruleRosNames= ruleRosNames EOF )
            // InternalRos1Parser.g:2325:2: iv_ruleRosNames= ruleRosNames EOF
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
    // InternalRos1Parser.g:2331:1: ruleRosNames returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node | kw= Class | kw= Library ) ;
    public final AntlrDatatypeRuleToken ruleRosNames() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ROS_CONVENTION_A_0=null;
        Token this_ID_1=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:2337:2: ( (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node | kw= Class | kw= Library ) )
            // InternalRos1Parser.g:2338:2: (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node | kw= Class | kw= Library )
            {
            // InternalRos1Parser.g:2338:2: (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node | kw= Class | kw= Library )
            int alt56=5;
            switch ( input.LA(1) ) {
            case RULE_ROS_CONVENTION_A:
                {
                alt56=1;
                }
                break;
            case RULE_ID:
                {
                alt56=2;
                }
                break;
            case Node:
                {
                alt56=3;
                }
                break;
            case Class:
                {
                alt56=4;
                }
                break;
            case Library:
                {
                alt56=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // InternalRos1Parser.g:2339:3: this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A
                    {
                    this_ROS_CONVENTION_A_0=(Token)match(input,RULE_ROS_CONVENTION_A,FOLLOW_2); 

                    			current.merge(this_ROS_CONVENTION_A_0);
                    		

                    			newLeafNode(this_ROS_CONVENTION_A_0, grammarAccess.getRosNamesAccess().getROS_CONVENTION_ATerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:2347:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getRosNamesAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRos1Parser.g:2355:3: kw= Node
                    {
                    kw=(Token)match(input,Node,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getRosNamesAccess().getNodeKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRos1Parser.g:2361:3: kw= Class
                    {
                    kw=(Token)match(input,Class,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getRosNamesAccess().getClassKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRos1Parser.g:2367:3: kw= Library
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
    // InternalRos1Parser.g:2376:1: entryRuleExtensionKey returns [String current=null] : iv_ruleExtensionKey= ruleExtensionKey EOF ;
    public final String entryRuleExtensionKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionKey = null;


        try {
            // InternalRos1Parser.g:2376:52: (iv_ruleExtensionKey= ruleExtensionKey EOF )
            // InternalRos1Parser.g:2377:2: iv_ruleExtensionKey= ruleExtensionKey EOF
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
    // InternalRos1Parser.g:2383:1: ruleExtensionKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= Class | kw= Library | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header ) ;
    public final AntlrDatatypeRuleToken ruleExtensionKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_STRING_1=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_KEYWORD_2 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:2389:2: ( (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= Class | kw= Library | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header ) )
            // InternalRos1Parser.g:2390:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= Class | kw= Library | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header )
            {
            // InternalRos1Parser.g:2390:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= Class | kw= Library | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header )
            int alt57=31;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt57=1;
                }
                break;
            case RULE_STRING:
                {
                alt57=2;
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
                alt57=3;
                }
                break;
            case Node:
                {
                alt57=4;
                }
                break;
            case Class:
                {
                alt57=5;
                }
                break;
            case Library:
                {
                alt57=6;
                }
                break;
            case String:
                {
                alt57=7;
                }
                break;
            case Integer:
                {
                alt57=8;
                }
                break;
            case Double:
                {
                alt57=9;
                }
                break;
            case Boolean:
                {
                alt57=10;
                }
                break;
            case Base64:
                {
                alt57=11;
                }
                break;
            case Array:
                {
                alt57=12;
                }
                break;
            case List:
                {
                alt57=13;
                }
                break;
            case Struct:
                {
                alt57=14;
                }
                break;
            case Date:
                {
                alt57=15;
                }
                break;
            case Any:
                {
                alt57=16;
                }
                break;
            case Bool:
                {
                alt57=17;
                }
                break;
            case Int8:
                {
                alt57=18;
                }
                break;
            case Uint8:
                {
                alt57=19;
                }
                break;
            case Int16:
                {
                alt57=20;
                }
                break;
            case Uint16:
                {
                alt57=21;
                }
                break;
            case Int32:
                {
                alt57=22;
                }
                break;
            case Uint32:
                {
                alt57=23;
                }
                break;
            case Int64:
                {
                alt57=24;
                }
                break;
            case Uint64:
                {
                alt57=25;
                }
                break;
            case Float32:
                {
                alt57=26;
                }
                break;
            case Float64:
                {
                alt57=27;
                }
                break;
            case String_1:
                {
                alt57=28;
                }
                break;
            case Char:
                {
                alt57=29;
                }
                break;
            case Byte:
                {
                alt57=30;
                }
                break;
            case Header:
                {
                alt57=31;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // InternalRos1Parser.g:2391:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_0);
                    		

                    			newLeafNode(this_ID_0, grammarAccess.getExtensionKeyAccess().getIDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:2399:3: this_STRING_1= RULE_STRING
                    {
                    this_STRING_1=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_1);
                    		

                    			newLeafNode(this_STRING_1, grammarAccess.getExtensionKeyAccess().getSTRINGTerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRos1Parser.g:2407:3: this_KEYWORD_2= ruleKEYWORD
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
                    // InternalRos1Parser.g:2418:3: kw= Node
                    {
                    kw=(Token)match(input,Node,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getNodeKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRos1Parser.g:2424:3: kw= Class
                    {
                    kw=(Token)match(input,Class,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getClassKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalRos1Parser.g:2430:3: kw= Library
                    {
                    kw=(Token)match(input,Library,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getLibraryKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalRos1Parser.g:2436:3: kw= String
                    {
                    kw=(Token)match(input,String,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getStringKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalRos1Parser.g:2442:3: kw= Integer
                    {
                    kw=(Token)match(input,Integer,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getIntegerKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalRos1Parser.g:2448:3: kw= Double
                    {
                    kw=(Token)match(input,Double,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getDoubleKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalRos1Parser.g:2454:3: kw= Boolean
                    {
                    kw=(Token)match(input,Boolean,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getBooleanKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalRos1Parser.g:2460:3: kw= Base64
                    {
                    kw=(Token)match(input,Base64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getBase64Keyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalRos1Parser.g:2466:3: kw= Array
                    {
                    kw=(Token)match(input,Array,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getArrayKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalRos1Parser.g:2472:3: kw= List
                    {
                    kw=(Token)match(input,List,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getListKeyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalRos1Parser.g:2478:3: kw= Struct
                    {
                    kw=(Token)match(input,Struct,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getStructKeyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalRos1Parser.g:2484:3: kw= Date
                    {
                    kw=(Token)match(input,Date,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getDateKeyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalRos1Parser.g:2490:3: kw= Any
                    {
                    kw=(Token)match(input,Any,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getAnyKeyword_15());
                    		

                    }
                    break;
                case 17 :
                    // InternalRos1Parser.g:2496:3: kw= Bool
                    {
                    kw=(Token)match(input,Bool,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getBoolKeyword_16());
                    		

                    }
                    break;
                case 18 :
                    // InternalRos1Parser.g:2502:3: kw= Int8
                    {
                    kw=(Token)match(input,Int8,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt8Keyword_17());
                    		

                    }
                    break;
                case 19 :
                    // InternalRos1Parser.g:2508:3: kw= Uint8
                    {
                    kw=(Token)match(input,Uint8,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint8Keyword_18());
                    		

                    }
                    break;
                case 20 :
                    // InternalRos1Parser.g:2514:3: kw= Int16
                    {
                    kw=(Token)match(input,Int16,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt16Keyword_19());
                    		

                    }
                    break;
                case 21 :
                    // InternalRos1Parser.g:2520:3: kw= Uint16
                    {
                    kw=(Token)match(input,Uint16,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint16Keyword_20());
                    		

                    }
                    break;
                case 22 :
                    // InternalRos1Parser.g:2526:3: kw= Int32
                    {
                    kw=(Token)match(input,Int32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt32Keyword_21());
                    		

                    }
                    break;
                case 23 :
                    // InternalRos1Parser.g:2532:3: kw= Uint32
                    {
                    kw=(Token)match(input,Uint32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint32Keyword_22());
                    		

                    }
                    break;
                case 24 :
                    // InternalRos1Parser.g:2538:3: kw= Int64
                    {
                    kw=(Token)match(input,Int64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt64Keyword_23());
                    		

                    }
                    break;
                case 25 :
                    // InternalRos1Parser.g:2544:3: kw= Uint64
                    {
                    kw=(Token)match(input,Uint64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint64Keyword_24());
                    		

                    }
                    break;
                case 26 :
                    // InternalRos1Parser.g:2550:3: kw= Float32
                    {
                    kw=(Token)match(input,Float32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getFloat32Keyword_25());
                    		

                    }
                    break;
                case 27 :
                    // InternalRos1Parser.g:2556:3: kw= Float64
                    {
                    kw=(Token)match(input,Float64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getFloat64Keyword_26());
                    		

                    }
                    break;
                case 28 :
                    // InternalRos1Parser.g:2562:3: kw= String_1
                    {
                    kw=(Token)match(input,String_1,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getStringKeyword_27());
                    		

                    }
                    break;
                case 29 :
                    // InternalRos1Parser.g:2568:3: kw= Char
                    {
                    kw=(Token)match(input,Char,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getCharKeyword_28());
                    		

                    }
                    break;
                case 30 :
                    // InternalRos1Parser.g:2574:3: kw= Byte
                    {
                    kw=(Token)match(input,Byte,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getByteKeyword_29());
                    		

                    }
                    break;
                case 31 :
                    // InternalRos1Parser.g:2580:3: kw= Header
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
    // InternalRos1Parser.g:2589:1: entryRuleExtensionColonKey returns [String current=null] : iv_ruleExtensionColonKey= ruleExtensionColonKey EOF ;
    public final String entryRuleExtensionColonKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionColonKey = null;


        try {
            // InternalRos1Parser.g:2589:57: (iv_ruleExtensionColonKey= ruleExtensionColonKey EOF )
            // InternalRos1Parser.g:2590:2: iv_ruleExtensionColonKey= ruleExtensionColonKey EOF
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
    // InternalRos1Parser.g:2596:1: ruleExtensionColonKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromGitRepo | kw= Dependencies | kw= Msgs | kw= Srvs | kw= Actions | kw= Node_1 | kw= Publishers | kw= Subscribers | kw= Serviceservers | kw= Serviceclients | kw= Actionservers | kw= Actionclients | kw= Parameters ) ;
    public final AntlrDatatypeRuleToken ruleExtensionColonKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:2602:2: ( (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromGitRepo | kw= Dependencies | kw= Msgs | kw= Srvs | kw= Actions | kw= Node_1 | kw= Publishers | kw= Subscribers | kw= Serviceservers | kw= Serviceclients | kw= Actionservers | kw= Actionclients | kw= Parameters ) )
            // InternalRos1Parser.g:2603:2: (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromGitRepo | kw= Dependencies | kw= Msgs | kw= Srvs | kw= Actions | kw= Node_1 | kw= Publishers | kw= Subscribers | kw= Serviceservers | kw= Serviceclients | kw= Actionservers | kw= Actionclients | kw= Parameters )
            {
            // InternalRos1Parser.g:2603:2: (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromGitRepo | kw= Dependencies | kw= Msgs | kw= Srvs | kw= Actions | kw= Node_1 | kw= Publishers | kw= Subscribers | kw= Serviceservers | kw= Serviceclients | kw= Actionservers | kw= Actionclients | kw= Parameters )
            int alt58=17;
            switch ( input.LA(1) ) {
            case Ns:
                {
                alt58=1;
                }
                break;
            case Type_1:
                {
                alt58=2;
                }
                break;
            case Value_1:
                {
                alt58=3;
                }
                break;
            case Default:
                {
                alt58=4;
                }
                break;
            case FromGitRepo:
                {
                alt58=5;
                }
                break;
            case Dependencies:
                {
                alt58=6;
                }
                break;
            case Msgs:
                {
                alt58=7;
                }
                break;
            case Srvs:
                {
                alt58=8;
                }
                break;
            case Actions:
                {
                alt58=9;
                }
                break;
            case Node_1:
                {
                alt58=10;
                }
                break;
            case Publishers:
                {
                alt58=11;
                }
                break;
            case Subscribers:
                {
                alt58=12;
                }
                break;
            case Serviceservers:
                {
                alt58=13;
                }
                break;
            case Serviceclients:
                {
                alt58=14;
                }
                break;
            case Actionservers:
                {
                alt58=15;
                }
                break;
            case Actionclients:
                {
                alt58=16;
                }
                break;
            case Parameters:
                {
                alt58=17;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // InternalRos1Parser.g:2604:3: kw= Ns
                    {
                    kw=(Token)match(input,Ns,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getNsKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:2610:3: kw= Type_1
                    {
                    kw=(Token)match(input,Type_1,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getTypeKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRos1Parser.g:2616:3: kw= Value_1
                    {
                    kw=(Token)match(input,Value_1,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getValueKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRos1Parser.g:2622:3: kw= Default
                    {
                    kw=(Token)match(input,Default,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getDefaultKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRos1Parser.g:2628:3: kw= FromGitRepo
                    {
                    kw=(Token)match(input,FromGitRepo,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getFromGitRepoKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalRos1Parser.g:2634:3: kw= Dependencies
                    {
                    kw=(Token)match(input,Dependencies,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getDependenciesKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalRos1Parser.g:2640:3: kw= Msgs
                    {
                    kw=(Token)match(input,Msgs,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getMsgsKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalRos1Parser.g:2646:3: kw= Srvs
                    {
                    kw=(Token)match(input,Srvs,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getSrvsKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalRos1Parser.g:2652:3: kw= Actions
                    {
                    kw=(Token)match(input,Actions,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getActionsKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalRos1Parser.g:2658:3: kw= Node_1
                    {
                    kw=(Token)match(input,Node_1,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getNodeKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalRos1Parser.g:2664:3: kw= Publishers
                    {
                    kw=(Token)match(input,Publishers,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getPublishersKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalRos1Parser.g:2670:3: kw= Subscribers
                    {
                    kw=(Token)match(input,Subscribers,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getSubscribersKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalRos1Parser.g:2676:3: kw= Serviceservers
                    {
                    kw=(Token)match(input,Serviceservers,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getServiceserversKeyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalRos1Parser.g:2682:3: kw= Serviceclients
                    {
                    kw=(Token)match(input,Serviceclients,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getServiceclientsKeyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalRos1Parser.g:2688:3: kw= Actionservers
                    {
                    kw=(Token)match(input,Actionservers,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getActionserversKeyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalRos1Parser.g:2694:3: kw= Actionclients
                    {
                    kw=(Token)match(input,Actionclients,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getActionclientsKeyword_15());
                    		

                    }
                    break;
                case 17 :
                    // InternalRos1Parser.g:2700:3: kw= Parameters
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
    // InternalRos1Parser.g:2709:1: entryRulePublisher returns [EObject current=null] : iv_rulePublisher= rulePublisher EOF ;
    public final EObject entryRulePublisher() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePublisher = null;


        try {
            // InternalRos1Parser.g:2709:50: (iv_rulePublisher= rulePublisher EOF )
            // InternalRos1Parser.g:2710:2: iv_rulePublisher= rulePublisher EOF
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
    // InternalRos1Parser.g:2716:1: rulePublisher returns [EObject current=null] : ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END ) ;
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
            // InternalRos1Parser.g:2722:2: ( ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END ) )
            // InternalRos1Parser.g:2723:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END )
            {
            // InternalRos1Parser.g:2723:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END )
            // InternalRos1Parser.g:2724:3: () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END
            {
            // InternalRos1Parser.g:2724:3: ()
            // InternalRos1Parser.g:2725:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPublisherAccess().getPublisherAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:2731:3: ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
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
                    // InternalRos1Parser.g:2732:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    {
                    // InternalRos1Parser.g:2732:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    // InternalRos1Parser.g:2733:5: ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon
                    {
                    // InternalRos1Parser.g:2733:5: ( (lv_name_1_0= ruleEString ) )
                    // InternalRos1Parser.g:2734:6: (lv_name_1_0= ruleEString )
                    {
                    // InternalRos1Parser.g:2734:6: (lv_name_1_0= ruleEString )
                    // InternalRos1Parser.g:2735:7: lv_name_1_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getPublisherAccess().getNameEStringParserRuleCall_1_0_0_0());
                    						
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

                    					newLeafNode(otherlv_2, grammarAccess.getPublisherAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:2758:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRos1Parser.g:2758:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRos1Parser.g:2759:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRos1Parser.g:2759:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRos1Parser.g:2760:6: lv_name_3_0= ruleAddedKeywordName
                    {

                    						newCompositeNode(grammarAccess.getPublisherAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_4);
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

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_53); 

            			newLeafNode(this_BEGIN_4, grammarAccess.getPublisherAccess().getBEGINTerminalRuleCall_2());
            		
            otherlv_5=(Token)match(input,Type_1,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getPublisherAccess().getTypeKeyword_3());
            		
            // InternalRos1Parser.g:2786:3: ( ( ruleEString ) )
            // InternalRos1Parser.g:2787:4: ( ruleEString )
            {
            // InternalRos1Parser.g:2787:4: ( ruleEString )
            // InternalRos1Parser.g:2788:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPublisherRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPublisherAccess().getMessageTopicSpecCrossReference_4_0());
            				
            pushFollow(FOLLOW_54);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos1Parser.g:2802:3: (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==Ns) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalRos1Parser.g:2803:4: otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) )
                    {
                    otherlv_7=(Token)match(input,Ns,FOLLOW_55); 

                    				newLeafNode(otherlv_7, grammarAccess.getPublisherAccess().getNsKeyword_5_0());
                    			
                    // InternalRos1Parser.g:2807:4: ( (lv_namespace_8_0= ruleNamespace ) )
                    // InternalRos1Parser.g:2808:5: (lv_namespace_8_0= ruleNamespace )
                    {
                    // InternalRos1Parser.g:2808:5: (lv_namespace_8_0= ruleNamespace )
                    // InternalRos1Parser.g:2809:6: lv_namespace_8_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getPublisherAccess().getNamespaceNamespaceParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_13);
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
    // InternalRos1Parser.g:2835:1: entryRuleSubscriber returns [EObject current=null] : iv_ruleSubscriber= ruleSubscriber EOF ;
    public final EObject entryRuleSubscriber() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubscriber = null;


        try {
            // InternalRos1Parser.g:2835:51: (iv_ruleSubscriber= ruleSubscriber EOF )
            // InternalRos1Parser.g:2836:2: iv_ruleSubscriber= ruleSubscriber EOF
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
    // InternalRos1Parser.g:2842:1: ruleSubscriber returns [EObject current=null] : ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END ) ;
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
            // InternalRos1Parser.g:2848:2: ( ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END ) )
            // InternalRos1Parser.g:2849:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END )
            {
            // InternalRos1Parser.g:2849:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END )
            // InternalRos1Parser.g:2850:3: () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END
            {
            // InternalRos1Parser.g:2850:3: ()
            // InternalRos1Parser.g:2851:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSubscriberAccess().getSubscriberAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:2857:3: ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
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
                    // InternalRos1Parser.g:2858:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    {
                    // InternalRos1Parser.g:2858:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    // InternalRos1Parser.g:2859:5: ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon
                    {
                    // InternalRos1Parser.g:2859:5: ( (lv_name_1_0= ruleEString ) )
                    // InternalRos1Parser.g:2860:6: (lv_name_1_0= ruleEString )
                    {
                    // InternalRos1Parser.g:2860:6: (lv_name_1_0= ruleEString )
                    // InternalRos1Parser.g:2861:7: lv_name_1_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getSubscriberAccess().getNameEStringParserRuleCall_1_0_0_0());
                    						
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

                    					newLeafNode(otherlv_2, grammarAccess.getSubscriberAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:2884:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRos1Parser.g:2884:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRos1Parser.g:2885:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRos1Parser.g:2885:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRos1Parser.g:2886:6: lv_name_3_0= ruleAddedKeywordName
                    {

                    						newCompositeNode(grammarAccess.getSubscriberAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_4);
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

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_53); 

            			newLeafNode(this_BEGIN_4, grammarAccess.getSubscriberAccess().getBEGINTerminalRuleCall_2());
            		
            otherlv_5=(Token)match(input,Type_1,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getSubscriberAccess().getTypeKeyword_3());
            		
            // InternalRos1Parser.g:2912:3: ( ( ruleEString ) )
            // InternalRos1Parser.g:2913:4: ( ruleEString )
            {
            // InternalRos1Parser.g:2913:4: ( ruleEString )
            // InternalRos1Parser.g:2914:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubscriberRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSubscriberAccess().getMessageTopicSpecCrossReference_4_0());
            				
            pushFollow(FOLLOW_54);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos1Parser.g:2928:3: (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==Ns) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalRos1Parser.g:2929:4: otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) )
                    {
                    otherlv_7=(Token)match(input,Ns,FOLLOW_55); 

                    				newLeafNode(otherlv_7, grammarAccess.getSubscriberAccess().getNsKeyword_5_0());
                    			
                    // InternalRos1Parser.g:2933:4: ( (lv_namespace_8_0= ruleNamespace ) )
                    // InternalRos1Parser.g:2934:5: (lv_namespace_8_0= ruleNamespace )
                    {
                    // InternalRos1Parser.g:2934:5: (lv_namespace_8_0= ruleNamespace )
                    // InternalRos1Parser.g:2935:6: lv_namespace_8_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getSubscriberAccess().getNamespaceNamespaceParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_13);
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
    // InternalRos1Parser.g:2961:1: entryRuleServiceServer returns [EObject current=null] : iv_ruleServiceServer= ruleServiceServer EOF ;
    public final EObject entryRuleServiceServer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceServer = null;


        try {
            // InternalRos1Parser.g:2961:54: (iv_ruleServiceServer= ruleServiceServer EOF )
            // InternalRos1Parser.g:2962:2: iv_ruleServiceServer= ruleServiceServer EOF
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
    // InternalRos1Parser.g:2968:1: ruleServiceServer returns [EObject current=null] : ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END ) ;
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
            // InternalRos1Parser.g:2974:2: ( ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END ) )
            // InternalRos1Parser.g:2975:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END )
            {
            // InternalRos1Parser.g:2975:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END )
            // InternalRos1Parser.g:2976:3: () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END
            {
            // InternalRos1Parser.g:2976:3: ()
            // InternalRos1Parser.g:2977:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getServiceServerAccess().getServiceServerAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:2983:3: ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==Library||LA63_0==Class||(LA63_0>=RULE_ID && LA63_0<=RULE_STRING)) ) {
                alt63=1;
            }
            else if ( (LA63_0==Pluginslots||LA63_0==Implements||LA63_0==Parameter||LA63_0==Multiple||LA63_0==Plugins||LA63_0==Format||LA63_0==Base) ) {
                alt63=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // InternalRos1Parser.g:2984:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    {
                    // InternalRos1Parser.g:2984:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    // InternalRos1Parser.g:2985:5: ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon
                    {
                    // InternalRos1Parser.g:2985:5: ( (lv_name_1_0= ruleEString ) )
                    // InternalRos1Parser.g:2986:6: (lv_name_1_0= ruleEString )
                    {
                    // InternalRos1Parser.g:2986:6: (lv_name_1_0= ruleEString )
                    // InternalRos1Parser.g:2987:7: lv_name_1_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getServiceServerAccess().getNameEStringParserRuleCall_1_0_0_0());
                    						
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

                    					newLeafNode(otherlv_2, grammarAccess.getServiceServerAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:3010:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRos1Parser.g:3010:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRos1Parser.g:3011:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRos1Parser.g:3011:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRos1Parser.g:3012:6: lv_name_3_0= ruleAddedKeywordName
                    {

                    						newCompositeNode(grammarAccess.getServiceServerAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_4);
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

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_53); 

            			newLeafNode(this_BEGIN_4, grammarAccess.getServiceServerAccess().getBEGINTerminalRuleCall_2());
            		
            otherlv_5=(Token)match(input,Type_1,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getServiceServerAccess().getTypeKeyword_3());
            		
            // InternalRos1Parser.g:3038:3: ( ( ruleEString ) )
            // InternalRos1Parser.g:3039:4: ( ruleEString )
            {
            // InternalRos1Parser.g:3039:4: ( ruleEString )
            // InternalRos1Parser.g:3040:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getServiceServerRule());
            					}
            				

            					newCompositeNode(grammarAccess.getServiceServerAccess().getServiceServiceSpecCrossReference_4_0());
            				
            pushFollow(FOLLOW_54);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos1Parser.g:3054:3: (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==Ns) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalRos1Parser.g:3055:4: otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) )
                    {
                    otherlv_7=(Token)match(input,Ns,FOLLOW_55); 

                    				newLeafNode(otherlv_7, grammarAccess.getServiceServerAccess().getNsKeyword_5_0());
                    			
                    // InternalRos1Parser.g:3059:4: ( (lv_namespace_8_0= ruleNamespace ) )
                    // InternalRos1Parser.g:3060:5: (lv_namespace_8_0= ruleNamespace )
                    {
                    // InternalRos1Parser.g:3060:5: (lv_namespace_8_0= ruleNamespace )
                    // InternalRos1Parser.g:3061:6: lv_namespace_8_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getServiceServerAccess().getNamespaceNamespaceParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_13);
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
    // InternalRos1Parser.g:3087:1: entryRuleServiceClient returns [EObject current=null] : iv_ruleServiceClient= ruleServiceClient EOF ;
    public final EObject entryRuleServiceClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceClient = null;


        try {
            // InternalRos1Parser.g:3087:54: (iv_ruleServiceClient= ruleServiceClient EOF )
            // InternalRos1Parser.g:3088:2: iv_ruleServiceClient= ruleServiceClient EOF
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
    // InternalRos1Parser.g:3094:1: ruleServiceClient returns [EObject current=null] : ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END ) ;
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
            // InternalRos1Parser.g:3100:2: ( ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END ) )
            // InternalRos1Parser.g:3101:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END )
            {
            // InternalRos1Parser.g:3101:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END )
            // InternalRos1Parser.g:3102:3: () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END
            {
            // InternalRos1Parser.g:3102:3: ()
            // InternalRos1Parser.g:3103:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getServiceClientAccess().getServiceClientAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:3109:3: ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==Library||LA65_0==Class||(LA65_0>=RULE_ID && LA65_0<=RULE_STRING)) ) {
                alt65=1;
            }
            else if ( (LA65_0==Pluginslots||LA65_0==Implements||LA65_0==Parameter||LA65_0==Multiple||LA65_0==Plugins||LA65_0==Format||LA65_0==Base) ) {
                alt65=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // InternalRos1Parser.g:3110:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    {
                    // InternalRos1Parser.g:3110:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    // InternalRos1Parser.g:3111:5: ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon
                    {
                    // InternalRos1Parser.g:3111:5: ( (lv_name_1_0= ruleEString ) )
                    // InternalRos1Parser.g:3112:6: (lv_name_1_0= ruleEString )
                    {
                    // InternalRos1Parser.g:3112:6: (lv_name_1_0= ruleEString )
                    // InternalRos1Parser.g:3113:7: lv_name_1_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getServiceClientAccess().getNameEStringParserRuleCall_1_0_0_0());
                    						
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

                    					newLeafNode(otherlv_2, grammarAccess.getServiceClientAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:3136:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRos1Parser.g:3136:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRos1Parser.g:3137:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRos1Parser.g:3137:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRos1Parser.g:3138:6: lv_name_3_0= ruleAddedKeywordName
                    {

                    						newCompositeNode(grammarAccess.getServiceClientAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_4);
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

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_53); 

            			newLeafNode(this_BEGIN_4, grammarAccess.getServiceClientAccess().getBEGINTerminalRuleCall_2());
            		
            otherlv_5=(Token)match(input,Type_1,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getServiceClientAccess().getTypeKeyword_3());
            		
            // InternalRos1Parser.g:3164:3: ( ( ruleEString ) )
            // InternalRos1Parser.g:3165:4: ( ruleEString )
            {
            // InternalRos1Parser.g:3165:4: ( ruleEString )
            // InternalRos1Parser.g:3166:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getServiceClientRule());
            					}
            				

            					newCompositeNode(grammarAccess.getServiceClientAccess().getServiceServiceSpecCrossReference_4_0());
            				
            pushFollow(FOLLOW_54);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos1Parser.g:3180:3: (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==Ns) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalRos1Parser.g:3181:4: otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) )
                    {
                    otherlv_7=(Token)match(input,Ns,FOLLOW_55); 

                    				newLeafNode(otherlv_7, grammarAccess.getServiceClientAccess().getNsKeyword_5_0());
                    			
                    // InternalRos1Parser.g:3185:4: ( (lv_namespace_8_0= ruleNamespace ) )
                    // InternalRos1Parser.g:3186:5: (lv_namespace_8_0= ruleNamespace )
                    {
                    // InternalRos1Parser.g:3186:5: (lv_namespace_8_0= ruleNamespace )
                    // InternalRos1Parser.g:3187:6: lv_namespace_8_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getServiceClientAccess().getNamespaceNamespaceParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_13);
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
    // InternalRos1Parser.g:3213:1: entryRuleActionServer returns [EObject current=null] : iv_ruleActionServer= ruleActionServer EOF ;
    public final EObject entryRuleActionServer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionServer = null;


        try {
            // InternalRos1Parser.g:3213:53: (iv_ruleActionServer= ruleActionServer EOF )
            // InternalRos1Parser.g:3214:2: iv_ruleActionServer= ruleActionServer EOF
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
    // InternalRos1Parser.g:3220:1: ruleActionServer returns [EObject current=null] : ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END ) ;
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
            // InternalRos1Parser.g:3226:2: ( ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END ) )
            // InternalRos1Parser.g:3227:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END )
            {
            // InternalRos1Parser.g:3227:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END )
            // InternalRos1Parser.g:3228:3: () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END
            {
            // InternalRos1Parser.g:3228:3: ()
            // InternalRos1Parser.g:3229:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getActionServerAccess().getActionServerAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:3235:3: ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==Library||LA67_0==Class||(LA67_0>=RULE_ID && LA67_0<=RULE_STRING)) ) {
                alt67=1;
            }
            else if ( (LA67_0==Pluginslots||LA67_0==Implements||LA67_0==Parameter||LA67_0==Multiple||LA67_0==Plugins||LA67_0==Format||LA67_0==Base) ) {
                alt67=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // InternalRos1Parser.g:3236:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    {
                    // InternalRos1Parser.g:3236:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    // InternalRos1Parser.g:3237:5: ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon
                    {
                    // InternalRos1Parser.g:3237:5: ( (lv_name_1_0= ruleEString ) )
                    // InternalRos1Parser.g:3238:6: (lv_name_1_0= ruleEString )
                    {
                    // InternalRos1Parser.g:3238:6: (lv_name_1_0= ruleEString )
                    // InternalRos1Parser.g:3239:7: lv_name_1_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getActionServerAccess().getNameEStringParserRuleCall_1_0_0_0());
                    						
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

                    					newLeafNode(otherlv_2, grammarAccess.getActionServerAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:3262:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRos1Parser.g:3262:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRos1Parser.g:3263:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRos1Parser.g:3263:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRos1Parser.g:3264:6: lv_name_3_0= ruleAddedKeywordName
                    {

                    						newCompositeNode(grammarAccess.getActionServerAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_4);
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

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_53); 

            			newLeafNode(this_BEGIN_4, grammarAccess.getActionServerAccess().getBEGINTerminalRuleCall_2());
            		
            otherlv_5=(Token)match(input,Type_1,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getActionServerAccess().getTypeKeyword_3());
            		
            // InternalRos1Parser.g:3290:3: ( ( ruleEString ) )
            // InternalRos1Parser.g:3291:4: ( ruleEString )
            {
            // InternalRos1Parser.g:3291:4: ( ruleEString )
            // InternalRos1Parser.g:3292:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionServerRule());
            					}
            				

            					newCompositeNode(grammarAccess.getActionServerAccess().getActionActionSpecCrossReference_4_0());
            				
            pushFollow(FOLLOW_54);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos1Parser.g:3306:3: (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==Ns) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalRos1Parser.g:3307:4: otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) )
                    {
                    otherlv_7=(Token)match(input,Ns,FOLLOW_55); 

                    				newLeafNode(otherlv_7, grammarAccess.getActionServerAccess().getNsKeyword_5_0());
                    			
                    // InternalRos1Parser.g:3311:4: ( (lv_namespace_8_0= ruleNamespace ) )
                    // InternalRos1Parser.g:3312:5: (lv_namespace_8_0= ruleNamespace )
                    {
                    // InternalRos1Parser.g:3312:5: (lv_namespace_8_0= ruleNamespace )
                    // InternalRos1Parser.g:3313:6: lv_namespace_8_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getActionServerAccess().getNamespaceNamespaceParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_13);
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
    // InternalRos1Parser.g:3339:1: entryRuleActionClient returns [EObject current=null] : iv_ruleActionClient= ruleActionClient EOF ;
    public final EObject entryRuleActionClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionClient = null;


        try {
            // InternalRos1Parser.g:3339:53: (iv_ruleActionClient= ruleActionClient EOF )
            // InternalRos1Parser.g:3340:2: iv_ruleActionClient= ruleActionClient EOF
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
    // InternalRos1Parser.g:3346:1: ruleActionClient returns [EObject current=null] : ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END ) ;
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
            // InternalRos1Parser.g:3352:2: ( ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END ) )
            // InternalRos1Parser.g:3353:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END )
            {
            // InternalRos1Parser.g:3353:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END )
            // InternalRos1Parser.g:3354:3: () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END
            {
            // InternalRos1Parser.g:3354:3: ()
            // InternalRos1Parser.g:3355:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getActionClientAccess().getActionClientAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:3361:3: ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==Library||LA69_0==Class||(LA69_0>=RULE_ID && LA69_0<=RULE_STRING)) ) {
                alt69=1;
            }
            else if ( (LA69_0==Pluginslots||LA69_0==Implements||LA69_0==Parameter||LA69_0==Multiple||LA69_0==Plugins||LA69_0==Format||LA69_0==Base) ) {
                alt69=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // InternalRos1Parser.g:3362:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    {
                    // InternalRos1Parser.g:3362:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    // InternalRos1Parser.g:3363:5: ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon
                    {
                    // InternalRos1Parser.g:3363:5: ( (lv_name_1_0= ruleEString ) )
                    // InternalRos1Parser.g:3364:6: (lv_name_1_0= ruleEString )
                    {
                    // InternalRos1Parser.g:3364:6: (lv_name_1_0= ruleEString )
                    // InternalRos1Parser.g:3365:7: lv_name_1_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getActionClientAccess().getNameEStringParserRuleCall_1_0_0_0());
                    						
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

                    					newLeafNode(otherlv_2, grammarAccess.getActionClientAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:3388:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRos1Parser.g:3388:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRos1Parser.g:3389:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRos1Parser.g:3389:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRos1Parser.g:3390:6: lv_name_3_0= ruleAddedKeywordName
                    {

                    						newCompositeNode(grammarAccess.getActionClientAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_4);
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

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_53); 

            			newLeafNode(this_BEGIN_4, grammarAccess.getActionClientAccess().getBEGINTerminalRuleCall_2());
            		
            otherlv_5=(Token)match(input,Type_1,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getActionClientAccess().getTypeKeyword_3());
            		
            // InternalRos1Parser.g:3416:3: ( ( ruleEString ) )
            // InternalRos1Parser.g:3417:4: ( ruleEString )
            {
            // InternalRos1Parser.g:3417:4: ( ruleEString )
            // InternalRos1Parser.g:3418:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionClientRule());
            					}
            				

            					newCompositeNode(grammarAccess.getActionClientAccess().getActionActionSpecCrossReference_4_0());
            				
            pushFollow(FOLLOW_54);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos1Parser.g:3432:3: (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==Ns) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalRos1Parser.g:3433:4: otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) )
                    {
                    otherlv_7=(Token)match(input,Ns,FOLLOW_55); 

                    				newLeafNode(otherlv_7, grammarAccess.getActionClientAccess().getNsKeyword_5_0());
                    			
                    // InternalRos1Parser.g:3437:4: ( (lv_namespace_8_0= ruleNamespace ) )
                    // InternalRos1Parser.g:3438:5: (lv_namespace_8_0= ruleNamespace )
                    {
                    // InternalRos1Parser.g:3438:5: (lv_namespace_8_0= ruleNamespace )
                    // InternalRos1Parser.g:3439:6: lv_namespace_8_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getActionClientAccess().getNamespaceNamespaceParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_13);
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
    // InternalRos1Parser.g:3465:1: entryRuleDependency returns [EObject current=null] : iv_ruleDependency= ruleDependency EOF ;
    public final EObject entryRuleDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDependency = null;


        try {
            // InternalRos1Parser.g:3465:51: (iv_ruleDependency= ruleDependency EOF )
            // InternalRos1Parser.g:3466:2: iv_ruleDependency= ruleDependency EOF
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
    // InternalRos1Parser.g:3472:1: ruleDependency returns [EObject current=null] : (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency ) ;
    public final EObject ruleDependency() throws RecognitionException {
        EObject current = null;

        EObject this_PackageDependency_0 = null;

        EObject this_ExternalDependency_1 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:3478:2: ( (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency ) )
            // InternalRos1Parser.g:3479:2: (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency )
            {
            // InternalRos1Parser.g:3479:2: (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==Library||LA71_0==Class||(LA71_0>=RULE_ID && LA71_0<=RULE_STRING)) ) {
                alt71=1;
            }
            else if ( (LA71_0==ExternalDependency) ) {
                alt71=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // InternalRos1Parser.g:3480:3: this_PackageDependency_0= rulePackageDependency
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
                    // InternalRos1Parser.g:3489:3: this_ExternalDependency_1= ruleExternalDependency
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
    // InternalRos1Parser.g:3501:1: entryRulePackageDependency returns [EObject current=null] : iv_rulePackageDependency= rulePackageDependency EOF ;
    public final EObject entryRulePackageDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDependency = null;


        try {
            // InternalRos1Parser.g:3501:58: (iv_rulePackageDependency= rulePackageDependency EOF )
            // InternalRos1Parser.g:3502:2: iv_rulePackageDependency= rulePackageDependency EOF
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
    // InternalRos1Parser.g:3508:1: rulePackageDependency returns [EObject current=null] : ( ( ruleEString ) ) ;
    public final EObject rulePackageDependency() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalRos1Parser.g:3514:2: ( ( ( ruleEString ) ) )
            // InternalRos1Parser.g:3515:2: ( ( ruleEString ) )
            {
            // InternalRos1Parser.g:3515:2: ( ( ruleEString ) )
            // InternalRos1Parser.g:3516:3: ( ruleEString )
            {
            // InternalRos1Parser.g:3516:3: ( ruleEString )
            // InternalRos1Parser.g:3517:4: ruleEString
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
    // InternalRos1Parser.g:3534:1: entryRuleExternalDependency returns [EObject current=null] : iv_ruleExternalDependency= ruleExternalDependency EOF ;
    public final EObject entryRuleExternalDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalDependency = null;


        try {
            // InternalRos1Parser.g:3534:59: (iv_ruleExternalDependency= ruleExternalDependency EOF )
            // InternalRos1Parser.g:3535:2: iv_ruleExternalDependency= ruleExternalDependency EOF
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
    // InternalRos1Parser.g:3541:1: ruleExternalDependency returns [EObject current=null] : ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleExternalDependency() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:3547:2: ( ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) ) )
            // InternalRos1Parser.g:3548:2: ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) )
            {
            // InternalRos1Parser.g:3548:2: ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) )
            // InternalRos1Parser.g:3549:3: () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) )
            {
            // InternalRos1Parser.g:3549:3: ()
            // InternalRos1Parser.g:3550:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExternalDependencyAccess().getExternalDependencyAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,ExternalDependency,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getExternalDependencyAccess().getExternalDependencyKeyword_1());
            		
            // InternalRos1Parser.g:3560:3: ( (lv_name_2_0= ruleEString ) )
            // InternalRos1Parser.g:3561:4: (lv_name_2_0= ruleEString )
            {
            // InternalRos1Parser.g:3561:4: (lv_name_2_0= ruleEString )
            // InternalRos1Parser.g:3562:5: lv_name_2_0= ruleEString
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
    // InternalRos1Parser.g:3583:1: entryRuleNamespace returns [EObject current=null] : iv_ruleNamespace= ruleNamespace EOF ;
    public final EObject entryRuleNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamespace = null;


        try {
            // InternalRos1Parser.g:3583:50: (iv_ruleNamespace= ruleNamespace EOF )
            // InternalRos1Parser.g:3584:2: iv_ruleNamespace= ruleNamespace EOF
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
    // InternalRos1Parser.g:3590:1: ruleNamespace returns [EObject current=null] : (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace ) ;
    public final EObject ruleNamespace() throws RecognitionException {
        EObject current = null;

        EObject this_GlobalNamespace_0 = null;

        EObject this_RelativeNamespace_Impl_1 = null;

        EObject this_PrivateNamespace_2 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:3596:2: ( (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace ) )
            // InternalRos1Parser.g:3597:2: (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace )
            {
            // InternalRos1Parser.g:3597:2: (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace )
            int alt72=3;
            switch ( input.LA(1) ) {
            case GlobalNamespace:
                {
                alt72=1;
                }
                break;
            case RelativeNamespace:
                {
                alt72=2;
                }
                break;
            case PrivateNamespace:
                {
                alt72=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }

            switch (alt72) {
                case 1 :
                    // InternalRos1Parser.g:3598:3: this_GlobalNamespace_0= ruleGlobalNamespace
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
                    // InternalRos1Parser.g:3607:3: this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl
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
                    // InternalRos1Parser.g:3616:3: this_PrivateNamespace_2= rulePrivateNamespace
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
    // InternalRos1Parser.g:3628:1: entryRuleGraphName returns [String current=null] : iv_ruleGraphName= ruleGraphName EOF ;
    public final String entryRuleGraphName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGraphName = null;


        try {
            // InternalRos1Parser.g:3628:49: (iv_ruleGraphName= ruleGraphName EOF )
            // InternalRos1Parser.g:3629:2: iv_ruleGraphName= ruleGraphName EOF
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
    // InternalRos1Parser.g:3635:1: ruleGraphName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= GraphName ;
    public final AntlrDatatypeRuleToken ruleGraphName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:3641:2: (kw= GraphName )
            // InternalRos1Parser.g:3642:2: kw= GraphName
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
    // InternalRos1Parser.g:3650:1: entryRuleGlobalNamespace returns [EObject current=null] : iv_ruleGlobalNamespace= ruleGlobalNamespace EOF ;
    public final EObject entryRuleGlobalNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalNamespace = null;


        try {
            // InternalRos1Parser.g:3650:56: (iv_ruleGlobalNamespace= ruleGlobalNamespace EOF )
            // InternalRos1Parser.g:3651:2: iv_ruleGlobalNamespace= ruleGlobalNamespace EOF
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
    // InternalRos1Parser.g:3657:1: ruleGlobalNamespace returns [EObject current=null] : ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
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
            // InternalRos1Parser.g:3663:2: ( ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRos1Parser.g:3664:2: ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRos1Parser.g:3664:2: ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRos1Parser.g:3665:3: () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRos1Parser.g:3665:3: ()
            // InternalRos1Parser.g:3666:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getGlobalNamespaceAccess().getGlobalNamespaceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,GlobalNamespace,FOLLOW_56); 

            			newLeafNode(otherlv_1, grammarAccess.getGlobalNamespaceAccess().getGlobalNamespaceKeyword_1());
            		
            // InternalRos1Parser.g:3676:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==LeftSquareBracket) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalRos1Parser.g:3677:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_57); 

                    				newLeafNode(otherlv_2, grammarAccess.getGlobalNamespaceAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalRos1Parser.g:3681:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRos1Parser.g:3682:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRos1Parser.g:3682:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRos1Parser.g:3683:6: lv_parts_3_0= ruleGraphName
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

                    // InternalRos1Parser.g:3700:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==Comma) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // InternalRos1Parser.g:3701:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_57); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getGlobalNamespaceAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalRos1Parser.g:3705:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRos1Parser.g:3706:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRos1Parser.g:3706:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRos1Parser.g:3707:7: lv_parts_5_0= ruleGraphName
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
                    	    break loop73;
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
    // InternalRos1Parser.g:3734:1: entryRuleRelativeNamespace_Impl returns [EObject current=null] : iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF ;
    public final EObject entryRuleRelativeNamespace_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelativeNamespace_Impl = null;


        try {
            // InternalRos1Parser.g:3734:63: (iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF )
            // InternalRos1Parser.g:3735:2: iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF
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
    // InternalRos1Parser.g:3741:1: ruleRelativeNamespace_Impl returns [EObject current=null] : ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
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
            // InternalRos1Parser.g:3747:2: ( ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRos1Parser.g:3748:2: ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRos1Parser.g:3748:2: ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRos1Parser.g:3749:3: () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRos1Parser.g:3749:3: ()
            // InternalRos1Parser.g:3750:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRelativeNamespace_ImplAccess().getRelativeNamespaceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,RelativeNamespace,FOLLOW_56); 

            			newLeafNode(otherlv_1, grammarAccess.getRelativeNamespace_ImplAccess().getRelativeNamespaceKeyword_1());
            		
            // InternalRos1Parser.g:3760:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==LeftSquareBracket) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalRos1Parser.g:3761:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_57); 

                    				newLeafNode(otherlv_2, grammarAccess.getRelativeNamespace_ImplAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalRos1Parser.g:3765:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRos1Parser.g:3766:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRos1Parser.g:3766:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRos1Parser.g:3767:6: lv_parts_3_0= ruleGraphName
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

                    // InternalRos1Parser.g:3784:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop75:
                    do {
                        int alt75=2;
                        int LA75_0 = input.LA(1);

                        if ( (LA75_0==Comma) ) {
                            alt75=1;
                        }


                        switch (alt75) {
                    	case 1 :
                    	    // InternalRos1Parser.g:3785:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_57); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getRelativeNamespace_ImplAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalRos1Parser.g:3789:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRos1Parser.g:3790:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRos1Parser.g:3790:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRos1Parser.g:3791:7: lv_parts_5_0= ruleGraphName
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
                    	    break loop75;
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
    // InternalRos1Parser.g:3818:1: entryRulePrivateNamespace returns [EObject current=null] : iv_rulePrivateNamespace= rulePrivateNamespace EOF ;
    public final EObject entryRulePrivateNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrivateNamespace = null;


        try {
            // InternalRos1Parser.g:3818:57: (iv_rulePrivateNamespace= rulePrivateNamespace EOF )
            // InternalRos1Parser.g:3819:2: iv_rulePrivateNamespace= rulePrivateNamespace EOF
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
    // InternalRos1Parser.g:3825:1: rulePrivateNamespace returns [EObject current=null] : ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
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
            // InternalRos1Parser.g:3831:2: ( ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRos1Parser.g:3832:2: ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRos1Parser.g:3832:2: ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRos1Parser.g:3833:3: () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRos1Parser.g:3833:3: ()
            // InternalRos1Parser.g:3834:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPrivateNamespaceAccess().getPrivateNamespaceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,PrivateNamespace,FOLLOW_56); 

            			newLeafNode(otherlv_1, grammarAccess.getPrivateNamespaceAccess().getPrivateNamespaceKeyword_1());
            		
            // InternalRos1Parser.g:3844:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==LeftSquareBracket) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalRos1Parser.g:3845:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_57); 

                    				newLeafNode(otherlv_2, grammarAccess.getPrivateNamespaceAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalRos1Parser.g:3849:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRos1Parser.g:3850:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRos1Parser.g:3850:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRos1Parser.g:3851:6: lv_parts_3_0= ruleGraphName
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

                    // InternalRos1Parser.g:3868:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop77:
                    do {
                        int alt77=2;
                        int LA77_0 = input.LA(1);

                        if ( (LA77_0==Comma) ) {
                            alt77=1;
                        }


                        switch (alt77) {
                    	case 1 :
                    	    // InternalRos1Parser.g:3869:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_57); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getPrivateNamespaceAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalRos1Parser.g:3873:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRos1Parser.g:3874:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRos1Parser.g:3874:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRos1Parser.g:3875:7: lv_parts_5_0= ruleGraphName
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
                    	    break loop77;
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
    // InternalRos1Parser.g:3902:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalRos1Parser.g:3902:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalRos1Parser.g:3903:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalRos1Parser.g:3909:1: ruleParameter returns [EObject current=null] : ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) ) )? otherlv_7= Type_1 ( (lv_type_8_0= ruleParameterType ) ) (otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) ) )? this_END_11= RULE_END ) ;
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
            // InternalRos1Parser.g:3915:2: ( ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) ) )? otherlv_7= Type_1 ( (lv_type_8_0= ruleParameterType ) ) (otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) ) )? this_END_11= RULE_END ) )
            // InternalRos1Parser.g:3916:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) ) )? otherlv_7= Type_1 ( (lv_type_8_0= ruleParameterType ) ) (otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) ) )? this_END_11= RULE_END )
            {
            // InternalRos1Parser.g:3916:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) ) )? otherlv_7= Type_1 ( (lv_type_8_0= ruleParameterType ) ) (otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) ) )? this_END_11= RULE_END )
            // InternalRos1Parser.g:3917:3: () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) ) )? otherlv_7= Type_1 ( (lv_type_8_0= ruleParameterType ) ) (otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) ) )? this_END_11= RULE_END
            {
            // InternalRos1Parser.g:3917:3: ()
            // InternalRos1Parser.g:3918:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterAccess().getParameterAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:3924:3: ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==Library||LA79_0==Class||(LA79_0>=RULE_ID && LA79_0<=RULE_STRING)) ) {
                alt79=1;
            }
            else if ( (LA79_0==Pluginslots||LA79_0==Implements||LA79_0==Parameter||LA79_0==Multiple||LA79_0==Plugins||LA79_0==Format||LA79_0==Base) ) {
                alt79=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }
            switch (alt79) {
                case 1 :
                    // InternalRos1Parser.g:3925:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    {
                    // InternalRos1Parser.g:3925:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    // InternalRos1Parser.g:3926:5: ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon
                    {
                    // InternalRos1Parser.g:3926:5: ( (lv_name_1_0= ruleEString ) )
                    // InternalRos1Parser.g:3927:6: (lv_name_1_0= ruleEString )
                    {
                    // InternalRos1Parser.g:3927:6: (lv_name_1_0= ruleEString )
                    // InternalRos1Parser.g:3928:7: lv_name_1_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getParameterAccess().getNameEStringParserRuleCall_1_0_0_0());
                    						
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

                    					newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:3951:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRos1Parser.g:3951:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRos1Parser.g:3952:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRos1Parser.g:3952:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRos1Parser.g:3953:6: lv_name_3_0= ruleAddedKeywordName
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_4);
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

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_58); 

            			newLeafNode(this_BEGIN_4, grammarAccess.getParameterAccess().getBEGINTerminalRuleCall_2());
            		
            // InternalRos1Parser.g:3975:3: (otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==Ns) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalRos1Parser.g:3976:4: otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) )
                    {
                    otherlv_5=(Token)match(input,Ns,FOLLOW_55); 

                    				newLeafNode(otherlv_5, grammarAccess.getParameterAccess().getNsKeyword_3_0());
                    			
                    // InternalRos1Parser.g:3980:4: ( (lv_namespace_6_0= ruleNamespace ) )
                    // InternalRos1Parser.g:3981:5: (lv_namespace_6_0= ruleNamespace )
                    {
                    // InternalRos1Parser.g:3981:5: (lv_namespace_6_0= ruleNamespace )
                    // InternalRos1Parser.g:3982:6: lv_namespace_6_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getNamespaceNamespaceParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_53);
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

            otherlv_7=(Token)match(input,Type_1,FOLLOW_59); 

            			newLeafNode(otherlv_7, grammarAccess.getParameterAccess().getTypeKeyword_4());
            		
            // InternalRos1Parser.g:4004:3: ( (lv_type_8_0= ruleParameterType ) )
            // InternalRos1Parser.g:4005:4: (lv_type_8_0= ruleParameterType )
            {
            // InternalRos1Parser.g:4005:4: (lv_type_8_0= ruleParameterType )
            // InternalRos1Parser.g:4006:5: lv_type_8_0= ruleParameterType
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getTypeParameterTypeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_60);
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

            // InternalRos1Parser.g:4023:3: (otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==Value_1) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalRos1Parser.g:4024:4: otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) )
                    {
                    otherlv_9=(Token)match(input,Value_1,FOLLOW_61); 

                    				newLeafNode(otherlv_9, grammarAccess.getParameterAccess().getValueKeyword_6_0());
                    			
                    // InternalRos1Parser.g:4028:4: ( (lv_value_10_0= ruleParameterValue ) )
                    // InternalRos1Parser.g:4029:5: (lv_value_10_0= ruleParameterValue )
                    {
                    // InternalRos1Parser.g:4029:5: (lv_value_10_0= ruleParameterValue )
                    // InternalRos1Parser.g:4030:6: lv_value_10_0= ruleParameterValue
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getValueParameterValueParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_13);
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
    // InternalRos1Parser.g:4056:1: entryRuleParameterType returns [EObject current=null] : iv_ruleParameterType= ruleParameterType EOF ;
    public final EObject entryRuleParameterType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterType = null;


        try {
            // InternalRos1Parser.g:4056:54: (iv_ruleParameterType= ruleParameterType EOF )
            // InternalRos1Parser.g:4057:2: iv_ruleParameterType= ruleParameterType EOF
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
    // InternalRos1Parser.g:4063:1: ruleParameterType returns [EObject current=null] : (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType ) ;
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
            // InternalRos1Parser.g:4069:2: ( (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType ) )
            // InternalRos1Parser.g:4070:2: (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType )
            {
            // InternalRos1Parser.g:4070:2: (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType )
            int alt82=8;
            switch ( input.LA(1) ) {
            case List:
                {
                alt82=1;
                }
                break;
            case Struct:
                {
                alt82=2;
                }
                break;
            case Integer:
                {
                alt82=3;
                }
                break;
            case String:
                {
                alt82=4;
                }
                break;
            case Double:
                {
                alt82=5;
                }
                break;
            case Boolean:
                {
                alt82=6;
                }
                break;
            case Base64:
                {
                alt82=7;
                }
                break;
            case Array:
                {
                alt82=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }

            switch (alt82) {
                case 1 :
                    // InternalRos1Parser.g:4071:3: this_ParameterListType_0= ruleParameterListType
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
                    // InternalRos1Parser.g:4080:3: this_ParameterStructType_1= ruleParameterStructType
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
                    // InternalRos1Parser.g:4089:3: this_ParameterIntegerType_2= ruleParameterIntegerType
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
                    // InternalRos1Parser.g:4098:3: this_ParameterStringType_3= ruleParameterStringType
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
                    // InternalRos1Parser.g:4107:3: this_ParameterDoubleType_4= ruleParameterDoubleType
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
                    // InternalRos1Parser.g:4116:3: this_ParameterBooleanType_5= ruleParameterBooleanType
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
                    // InternalRos1Parser.g:4125:3: this_ParameterBase64Type_6= ruleParameterBase64Type
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
                    // InternalRos1Parser.g:4134:3: this_ParameterArrayType_7= ruleParameterArrayType
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
    // InternalRos1Parser.g:4146:1: entryRuleParameterValue returns [EObject current=null] : iv_ruleParameterValue= ruleParameterValue EOF ;
    public final EObject entryRuleParameterValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterValue = null;


        try {
            // InternalRos1Parser.g:4146:55: (iv_ruleParameterValue= ruleParameterValue EOF )
            // InternalRos1Parser.g:4147:2: iv_ruleParameterValue= ruleParameterValue EOF
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
    // InternalRos1Parser.g:4153:1: ruleParameterValue returns [EObject current=null] : (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct ) ;
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
            // InternalRos1Parser.g:4159:2: ( (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct ) )
            // InternalRos1Parser.g:4160:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )
            {
            // InternalRos1Parser.g:4160:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )
            int alt83=7;
            alt83 = dfa83.predict(input);
            switch (alt83) {
                case 1 :
                    // InternalRos1Parser.g:4161:3: this_ParameterString_0= ruleParameterString
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
                    // InternalRos1Parser.g:4170:3: this_ParameterBase64_1= ruleParameterBase64
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
                    // InternalRos1Parser.g:4179:3: this_ParameterInteger_2= ruleParameterInteger
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
                    // InternalRos1Parser.g:4188:3: this_ParameterDouble_3= ruleParameterDouble
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
                    // InternalRos1Parser.g:4197:3: this_ParameterBoolean_4= ruleParameterBoolean
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
                    // InternalRos1Parser.g:4206:3: this_ParameterList_5= ruleParameterList
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
                    // InternalRos1Parser.g:4215:3: this_ParameterStruct_6= ruleParameterStruct
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
    // InternalRos1Parser.g:4227:1: entryRuleParameterListType returns [EObject current=null] : iv_ruleParameterListType= ruleParameterListType EOF ;
    public final EObject entryRuleParameterListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterListType = null;


        try {
            // InternalRos1Parser.g:4227:58: (iv_ruleParameterListType= ruleParameterListType EOF )
            // InternalRos1Parser.g:4228:2: iv_ruleParameterListType= ruleParameterListType EOF
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
    // InternalRos1Parser.g:4234:1: ruleParameterListType returns [EObject current=null] : ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket ) ;
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
            // InternalRos1Parser.g:4240:2: ( ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket ) )
            // InternalRos1Parser.g:4241:2: ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket )
            {
            // InternalRos1Parser.g:4241:2: ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket )
            // InternalRos1Parser.g:4242:3: () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket
            {
            // InternalRos1Parser.g:4242:3: ()
            // InternalRos1Parser.g:4243:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterListTypeAccess().getParameterListTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,List,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterListTypeAccess().getListKeyword_1());
            		
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_59); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterListTypeAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalRos1Parser.g:4257:3: ( (lv_sequence_3_0= ruleParameterType ) )
            // InternalRos1Parser.g:4258:4: (lv_sequence_3_0= ruleParameterType )
            {
            // InternalRos1Parser.g:4258:4: (lv_sequence_3_0= ruleParameterType )
            // InternalRos1Parser.g:4259:5: lv_sequence_3_0= ruleParameterType
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

            // InternalRos1Parser.g:4276:3: (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==Comma) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // InternalRos1Parser.g:4277:4: otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) )
            	    {
            	    otherlv_4=(Token)match(input,Comma,FOLLOW_59); 

            	    				newLeafNode(otherlv_4, grammarAccess.getParameterListTypeAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalRos1Parser.g:4281:4: ( (lv_sequence_5_0= ruleParameterType ) )
            	    // InternalRos1Parser.g:4282:5: (lv_sequence_5_0= ruleParameterType )
            	    {
            	    // InternalRos1Parser.g:4282:5: (lv_sequence_5_0= ruleParameterType )
            	    // InternalRos1Parser.g:4283:6: lv_sequence_5_0= ruleParameterType
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
            	    break loop84;
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
    // InternalRos1Parser.g:4309:1: entryRuleParameterStructType returns [EObject current=null] : iv_ruleParameterStructType= ruleParameterStructType EOF ;
    public final EObject entryRuleParameterStructType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructType = null;


        try {
            // InternalRos1Parser.g:4309:60: (iv_ruleParameterStructType= ruleParameterStructType EOF )
            // InternalRos1Parser.g:4310:2: iv_ruleParameterStructType= ruleParameterStructType EOF
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
    // InternalRos1Parser.g:4316:1: ruleParameterStructType returns [EObject current=null] : ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket ) ;
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
            // InternalRos1Parser.g:4322:2: ( ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket ) )
            // InternalRos1Parser.g:4323:2: ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket )
            {
            // InternalRos1Parser.g:4323:2: ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket )
            // InternalRos1Parser.g:4324:3: () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket
            {
            // InternalRos1Parser.g:4324:3: ()
            // InternalRos1Parser.g:4325:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterStructTypeAccess().getParameterStructTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Struct,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterStructTypeAccess().getStructKeyword_1());
            		
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterStructTypeAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalRos1Parser.g:4339:3: ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) )
            // InternalRos1Parser.g:4340:4: (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember )
            {
            // InternalRos1Parser.g:4340:4: (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember )
            // InternalRos1Parser.g:4341:5: lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember
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

            // InternalRos1Parser.g:4358:3: (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==Comma) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // InternalRos1Parser.g:4359:4: otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) )
            	    {
            	    otherlv_4=(Token)match(input,Comma,FOLLOW_6); 

            	    				newLeafNode(otherlv_4, grammarAccess.getParameterStructTypeAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalRos1Parser.g:4363:4: ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) )
            	    // InternalRos1Parser.g:4364:5: (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember )
            	    {
            	    // InternalRos1Parser.g:4364:5: (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember )
            	    // InternalRos1Parser.g:4365:6: lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember
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
            	    break loop85;
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
    // InternalRos1Parser.g:4391:1: entryRuleParameterIntegerType returns [EObject current=null] : iv_ruleParameterIntegerType= ruleParameterIntegerType EOF ;
    public final EObject entryRuleParameterIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterIntegerType = null;


        try {
            // InternalRos1Parser.g:4391:61: (iv_ruleParameterIntegerType= ruleParameterIntegerType EOF )
            // InternalRos1Parser.g:4392:2: iv_ruleParameterIntegerType= ruleParameterIntegerType EOF
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
    // InternalRos1Parser.g:4398:1: ruleParameterIntegerType returns [EObject current=null] : ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? ) ;
    public final EObject ruleParameterIntegerType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4404:2: ( ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? ) )
            // InternalRos1Parser.g:4405:2: ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? )
            {
            // InternalRos1Parser.g:4405:2: ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? )
            // InternalRos1Parser.g:4406:3: () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )?
            {
            // InternalRos1Parser.g:4406:3: ()
            // InternalRos1Parser.g:4407:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterIntegerTypeAccess().getParameterIntegerTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Integer,FOLLOW_62); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterIntegerTypeAccess().getIntegerKeyword_1());
            		
            // InternalRos1Parser.g:4417:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==Default) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalRos1Parser.g:4418:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_63); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterIntegerTypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRos1Parser.g:4422:4: ( (lv_default_3_0= ruleParameterInteger ) )
                    // InternalRos1Parser.g:4423:5: (lv_default_3_0= ruleParameterInteger )
                    {
                    // InternalRos1Parser.g:4423:5: (lv_default_3_0= ruleParameterInteger )
                    // InternalRos1Parser.g:4424:6: lv_default_3_0= ruleParameterInteger
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
    // InternalRos1Parser.g:4446:1: entryRuleParameterStringType returns [EObject current=null] : iv_ruleParameterStringType= ruleParameterStringType EOF ;
    public final EObject entryRuleParameterStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStringType = null;


        try {
            // InternalRos1Parser.g:4446:60: (iv_ruleParameterStringType= ruleParameterStringType EOF )
            // InternalRos1Parser.g:4447:2: iv_ruleParameterStringType= ruleParameterStringType EOF
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
    // InternalRos1Parser.g:4453:1: ruleParameterStringType returns [EObject current=null] : ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? ) ;
    public final EObject ruleParameterStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4459:2: ( ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? ) )
            // InternalRos1Parser.g:4460:2: ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? )
            {
            // InternalRos1Parser.g:4460:2: ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? )
            // InternalRos1Parser.g:4461:3: () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )?
            {
            // InternalRos1Parser.g:4461:3: ()
            // InternalRos1Parser.g:4462:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterStringTypeAccess().getParameterStringTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,String,FOLLOW_62); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterStringTypeAccess().getStringKeyword_1());
            		
            // InternalRos1Parser.g:4472:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==Default) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalRos1Parser.g:4473:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_6); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterStringTypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRos1Parser.g:4477:4: ( (lv_default_3_0= ruleParameterString ) )
                    // InternalRos1Parser.g:4478:5: (lv_default_3_0= ruleParameterString )
                    {
                    // InternalRos1Parser.g:4478:5: (lv_default_3_0= ruleParameterString )
                    // InternalRos1Parser.g:4479:6: lv_default_3_0= ruleParameterString
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
    // InternalRos1Parser.g:4501:1: entryRuleParameterDoubleType returns [EObject current=null] : iv_ruleParameterDoubleType= ruleParameterDoubleType EOF ;
    public final EObject entryRuleParameterDoubleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDoubleType = null;


        try {
            // InternalRos1Parser.g:4501:60: (iv_ruleParameterDoubleType= ruleParameterDoubleType EOF )
            // InternalRos1Parser.g:4502:2: iv_ruleParameterDoubleType= ruleParameterDoubleType EOF
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
    // InternalRos1Parser.g:4508:1: ruleParameterDoubleType returns [EObject current=null] : ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? ) ;
    public final EObject ruleParameterDoubleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4514:2: ( ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? ) )
            // InternalRos1Parser.g:4515:2: ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? )
            {
            // InternalRos1Parser.g:4515:2: ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? )
            // InternalRos1Parser.g:4516:3: () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )?
            {
            // InternalRos1Parser.g:4516:3: ()
            // InternalRos1Parser.g:4517:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterDoubleTypeAccess().getParameterDoubleTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Double,FOLLOW_62); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterDoubleTypeAccess().getDoubleKeyword_1());
            		
            // InternalRos1Parser.g:4527:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==Default) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalRos1Parser.g:4528:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_64); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterDoubleTypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRos1Parser.g:4532:4: ( (lv_default_3_0= ruleParameterDouble ) )
                    // InternalRos1Parser.g:4533:5: (lv_default_3_0= ruleParameterDouble )
                    {
                    // InternalRos1Parser.g:4533:5: (lv_default_3_0= ruleParameterDouble )
                    // InternalRos1Parser.g:4534:6: lv_default_3_0= ruleParameterDouble
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
    // InternalRos1Parser.g:4556:1: entryRuleParameterBooleanType returns [EObject current=null] : iv_ruleParameterBooleanType= ruleParameterBooleanType EOF ;
    public final EObject entryRuleParameterBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBooleanType = null;


        try {
            // InternalRos1Parser.g:4556:61: (iv_ruleParameterBooleanType= ruleParameterBooleanType EOF )
            // InternalRos1Parser.g:4557:2: iv_ruleParameterBooleanType= ruleParameterBooleanType EOF
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
    // InternalRos1Parser.g:4563:1: ruleParameterBooleanType returns [EObject current=null] : ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? ) ;
    public final EObject ruleParameterBooleanType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4569:2: ( ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? ) )
            // InternalRos1Parser.g:4570:2: ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? )
            {
            // InternalRos1Parser.g:4570:2: ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? )
            // InternalRos1Parser.g:4571:3: () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )?
            {
            // InternalRos1Parser.g:4571:3: ()
            // InternalRos1Parser.g:4572:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterBooleanTypeAccess().getParameterBooleanTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Boolean,FOLLOW_62); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterBooleanTypeAccess().getBooleanKeyword_1());
            		
            // InternalRos1Parser.g:4582:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==Default) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // InternalRos1Parser.g:4583:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_42); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterBooleanTypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRos1Parser.g:4587:4: ( (lv_default_3_0= ruleParameterBoolean ) )
                    // InternalRos1Parser.g:4588:5: (lv_default_3_0= ruleParameterBoolean )
                    {
                    // InternalRos1Parser.g:4588:5: (lv_default_3_0= ruleParameterBoolean )
                    // InternalRos1Parser.g:4589:6: lv_default_3_0= ruleParameterBoolean
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
    // InternalRos1Parser.g:4611:1: entryRuleParameterBase64Type returns [EObject current=null] : iv_ruleParameterBase64Type= ruleParameterBase64Type EOF ;
    public final EObject entryRuleParameterBase64Type() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBase64Type = null;


        try {
            // InternalRos1Parser.g:4611:60: (iv_ruleParameterBase64Type= ruleParameterBase64Type EOF )
            // InternalRos1Parser.g:4612:2: iv_ruleParameterBase64Type= ruleParameterBase64Type EOF
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
    // InternalRos1Parser.g:4618:1: ruleParameterBase64Type returns [EObject current=null] : ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? ) ;
    public final EObject ruleParameterBase64Type() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4624:2: ( ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? ) )
            // InternalRos1Parser.g:4625:2: ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? )
            {
            // InternalRos1Parser.g:4625:2: ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? )
            // InternalRos1Parser.g:4626:3: () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )?
            {
            // InternalRos1Parser.g:4626:3: ()
            // InternalRos1Parser.g:4627:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterBase64TypeAccess().getParameterBase64TypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Base64,FOLLOW_62); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterBase64TypeAccess().getBase64Keyword_1());
            		
            // InternalRos1Parser.g:4637:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==Default) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalRos1Parser.g:4638:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_65); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterBase64TypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRos1Parser.g:4642:4: ( (lv_default_3_0= ruleParameterBase64 ) )
                    // InternalRos1Parser.g:4643:5: (lv_default_3_0= ruleParameterBase64 )
                    {
                    // InternalRos1Parser.g:4643:5: (lv_default_3_0= ruleParameterBase64 )
                    // InternalRos1Parser.g:4644:6: lv_default_3_0= ruleParameterBase64
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
    // InternalRos1Parser.g:4666:1: entryRuleParameterArrayType returns [EObject current=null] : iv_ruleParameterArrayType= ruleParameterArrayType EOF ;
    public final EObject entryRuleParameterArrayType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterArrayType = null;


        try {
            // InternalRos1Parser.g:4666:59: (iv_ruleParameterArrayType= ruleParameterArrayType EOF )
            // InternalRos1Parser.g:4667:2: iv_ruleParameterArrayType= ruleParameterArrayType EOF
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
    // InternalRos1Parser.g:4673:1: ruleParameterArrayType returns [EObject current=null] : (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? ) ;
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
            // InternalRos1Parser.g:4679:2: ( (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? ) )
            // InternalRos1Parser.g:4680:2: (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? )
            {
            // InternalRos1Parser.g:4680:2: (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? )
            // InternalRos1Parser.g:4681:3: otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )?
            {
            otherlv_0=(Token)match(input,Array,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getParameterArrayTypeAccess().getArrayKeyword_0());
            		
            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_59); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterArrayTypeAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalRos1Parser.g:4689:3: ( (lv_type_2_0= ruleParameterType ) )
            // InternalRos1Parser.g:4690:4: (lv_type_2_0= ruleParameterType )
            {
            // InternalRos1Parser.g:4690:4: (lv_type_2_0= ruleParameterType )
            // InternalRos1Parser.g:4691:5: lv_type_2_0= ruleParameterType
            {

            					newCompositeNode(grammarAccess.getParameterArrayTypeAccess().getTypeParameterTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_66);
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

            otherlv_3=(Token)match(input,RightSquareBracket,FOLLOW_62); 

            			newLeafNode(otherlv_3, grammarAccess.getParameterArrayTypeAccess().getRightSquareBracketKeyword_3());
            		
            // InternalRos1Parser.g:4712:3: (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==Default) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // InternalRos1Parser.g:4713:4: otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) )
                    {
                    otherlv_4=(Token)match(input,Default,FOLLOW_10); 

                    				newLeafNode(otherlv_4, grammarAccess.getParameterArrayTypeAccess().getDefaultKeyword_4_0());
                    			
                    // InternalRos1Parser.g:4717:4: ( (lv_default_5_0= ruleParameterList ) )
                    // InternalRos1Parser.g:4718:5: (lv_default_5_0= ruleParameterList )
                    {
                    // InternalRos1Parser.g:4718:5: (lv_default_5_0= ruleParameterList )
                    // InternalRos1Parser.g:4719:6: lv_default_5_0= ruleParameterList
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
    // InternalRos1Parser.g:4741:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterList = null;


        try {
            // InternalRos1Parser.g:4741:54: (iv_ruleParameterList= ruleParameterList EOF )
            // InternalRos1Parser.g:4742:2: iv_ruleParameterList= ruleParameterList EOF
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
    // InternalRos1Parser.g:4748:1: ruleParameterList returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_value_2_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4754:2: ( ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket ) )
            // InternalRos1Parser.g:4755:2: ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket )
            {
            // InternalRos1Parser.g:4755:2: ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket )
            // InternalRos1Parser.g:4756:3: () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket
            {
            // InternalRos1Parser.g:4756:3: ()
            // InternalRos1Parser.g:4757:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterListAccess().getParameterSequenceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_61); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalRos1Parser.g:4767:3: ( (lv_value_2_0= ruleParameterValue ) )
            // InternalRos1Parser.g:4768:4: (lv_value_2_0= ruleParameterValue )
            {
            // InternalRos1Parser.g:4768:4: (lv_value_2_0= ruleParameterValue )
            // InternalRos1Parser.g:4769:5: lv_value_2_0= ruleParameterValue
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

            // InternalRos1Parser.g:4786:3: (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==Comma) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // InternalRos1Parser.g:4787:4: otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) )
            	    {
            	    otherlv_3=(Token)match(input,Comma,FOLLOW_61); 

            	    				newLeafNode(otherlv_3, grammarAccess.getParameterListAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalRos1Parser.g:4791:4: ( (lv_value_4_0= ruleParameterValue ) )
            	    // InternalRos1Parser.g:4792:5: (lv_value_4_0= ruleParameterValue )
            	    {
            	    // InternalRos1Parser.g:4792:5: (lv_value_4_0= ruleParameterValue )
            	    // InternalRos1Parser.g:4793:6: lv_value_4_0= ruleParameterValue
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
            	    break loop92;
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
    // InternalRos1Parser.g:4819:1: entryRuleParameterAny returns [EObject current=null] : iv_ruleParameterAny= ruleParameterAny EOF ;
    public final EObject entryRuleParameterAny() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterAny = null;


        try {
            // InternalRos1Parser.g:4819:53: (iv_ruleParameterAny= ruleParameterAny EOF )
            // InternalRos1Parser.g:4820:2: iv_ruleParameterAny= ruleParameterAny EOF
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
    // InternalRos1Parser.g:4826:1: ruleParameterAny returns [EObject current=null] : ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? ) ;
    public final EObject ruleParameterAny() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4832:2: ( ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? ) )
            // InternalRos1Parser.g:4833:2: ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? )
            {
            // InternalRos1Parser.g:4833:2: ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? )
            // InternalRos1Parser.g:4834:3: () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )?
            {
            // InternalRos1Parser.g:4834:3: ()
            // InternalRos1Parser.g:4835:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterAnyAccess().getParameterAnyAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,ParameterAny,FOLLOW_67); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterAnyAccess().getParameterAnyKeyword_1());
            		
            // InternalRos1Parser.g:4845:3: (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==Value) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // InternalRos1Parser.g:4846:4: otherlv_2= Value ( (lv_value_3_0= ruleEString ) )
                    {
                    otherlv_2=(Token)match(input,Value,FOLLOW_6); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterAnyAccess().getValueKeyword_2_0());
                    			
                    // InternalRos1Parser.g:4850:4: ( (lv_value_3_0= ruleEString ) )
                    // InternalRos1Parser.g:4851:5: (lv_value_3_0= ruleEString )
                    {
                    // InternalRos1Parser.g:4851:5: (lv_value_3_0= ruleEString )
                    // InternalRos1Parser.g:4852:6: lv_value_3_0= ruleEString
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
    // InternalRos1Parser.g:4874:1: entryRuleParameterString returns [EObject current=null] : iv_ruleParameterString= ruleParameterString EOF ;
    public final EObject entryRuleParameterString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterString = null;


        try {
            // InternalRos1Parser.g:4874:56: (iv_ruleParameterString= ruleParameterString EOF )
            // InternalRos1Parser.g:4875:2: iv_ruleParameterString= ruleParameterString EOF
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
    // InternalRos1Parser.g:4881:1: ruleParameterString returns [EObject current=null] : ( (lv_value_0_0= ruleEString ) ) ;
    public final EObject ruleParameterString() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4887:2: ( ( (lv_value_0_0= ruleEString ) ) )
            // InternalRos1Parser.g:4888:2: ( (lv_value_0_0= ruleEString ) )
            {
            // InternalRos1Parser.g:4888:2: ( (lv_value_0_0= ruleEString ) )
            // InternalRos1Parser.g:4889:3: (lv_value_0_0= ruleEString )
            {
            // InternalRos1Parser.g:4889:3: (lv_value_0_0= ruleEString )
            // InternalRos1Parser.g:4890:4: lv_value_0_0= ruleEString
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
    // InternalRos1Parser.g:4910:1: entryRuleParameterBase64 returns [EObject current=null] : iv_ruleParameterBase64= ruleParameterBase64 EOF ;
    public final EObject entryRuleParameterBase64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBase64 = null;


        try {
            // InternalRos1Parser.g:4910:56: (iv_ruleParameterBase64= ruleParameterBase64 EOF )
            // InternalRos1Parser.g:4911:2: iv_ruleParameterBase64= ruleParameterBase64 EOF
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
    // InternalRos1Parser.g:4917:1: ruleParameterBase64 returns [EObject current=null] : ( (lv_value_0_0= ruleBase64Binary ) ) ;
    public final EObject ruleParameterBase64() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4923:2: ( ( (lv_value_0_0= ruleBase64Binary ) ) )
            // InternalRos1Parser.g:4924:2: ( (lv_value_0_0= ruleBase64Binary ) )
            {
            // InternalRos1Parser.g:4924:2: ( (lv_value_0_0= ruleBase64Binary ) )
            // InternalRos1Parser.g:4925:3: (lv_value_0_0= ruleBase64Binary )
            {
            // InternalRos1Parser.g:4925:3: (lv_value_0_0= ruleBase64Binary )
            // InternalRos1Parser.g:4926:4: lv_value_0_0= ruleBase64Binary
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
    // InternalRos1Parser.g:4946:1: entryRuleParameterInteger returns [EObject current=null] : iv_ruleParameterInteger= ruleParameterInteger EOF ;
    public final EObject entryRuleParameterInteger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterInteger = null;


        try {
            // InternalRos1Parser.g:4946:57: (iv_ruleParameterInteger= ruleParameterInteger EOF )
            // InternalRos1Parser.g:4947:2: iv_ruleParameterInteger= ruleParameterInteger EOF
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
    // InternalRos1Parser.g:4953:1: ruleParameterInteger returns [EObject current=null] : ( (lv_value_0_0= ruleInteger0 ) ) ;
    public final EObject ruleParameterInteger() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4959:2: ( ( (lv_value_0_0= ruleInteger0 ) ) )
            // InternalRos1Parser.g:4960:2: ( (lv_value_0_0= ruleInteger0 ) )
            {
            // InternalRos1Parser.g:4960:2: ( (lv_value_0_0= ruleInteger0 ) )
            // InternalRos1Parser.g:4961:3: (lv_value_0_0= ruleInteger0 )
            {
            // InternalRos1Parser.g:4961:3: (lv_value_0_0= ruleInteger0 )
            // InternalRos1Parser.g:4962:4: lv_value_0_0= ruleInteger0
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
    // InternalRos1Parser.g:4982:1: entryRuleParameterDouble returns [EObject current=null] : iv_ruleParameterDouble= ruleParameterDouble EOF ;
    public final EObject entryRuleParameterDouble() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDouble = null;


        try {
            // InternalRos1Parser.g:4982:56: (iv_ruleParameterDouble= ruleParameterDouble EOF )
            // InternalRos1Parser.g:4983:2: iv_ruleParameterDouble= ruleParameterDouble EOF
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
    // InternalRos1Parser.g:4989:1: ruleParameterDouble returns [EObject current=null] : ( (lv_value_0_0= ruleDouble0 ) ) ;
    public final EObject ruleParameterDouble() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4995:2: ( ( (lv_value_0_0= ruleDouble0 ) ) )
            // InternalRos1Parser.g:4996:2: ( (lv_value_0_0= ruleDouble0 ) )
            {
            // InternalRos1Parser.g:4996:2: ( (lv_value_0_0= ruleDouble0 ) )
            // InternalRos1Parser.g:4997:3: (lv_value_0_0= ruleDouble0 )
            {
            // InternalRos1Parser.g:4997:3: (lv_value_0_0= ruleDouble0 )
            // InternalRos1Parser.g:4998:4: lv_value_0_0= ruleDouble0
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
    // InternalRos1Parser.g:5018:1: entryRuleParameterBoolean returns [EObject current=null] : iv_ruleParameterBoolean= ruleParameterBoolean EOF ;
    public final EObject entryRuleParameterBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBoolean = null;


        try {
            // InternalRos1Parser.g:5018:57: (iv_ruleParameterBoolean= ruleParameterBoolean EOF )
            // InternalRos1Parser.g:5019:2: iv_ruleParameterBoolean= ruleParameterBoolean EOF
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
    // InternalRos1Parser.g:5025:1: ruleParameterBoolean returns [EObject current=null] : ( (lv_value_0_0= ruleboolean0 ) ) ;
    public final EObject ruleParameterBoolean() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:5031:2: ( ( (lv_value_0_0= ruleboolean0 ) ) )
            // InternalRos1Parser.g:5032:2: ( (lv_value_0_0= ruleboolean0 ) )
            {
            // InternalRos1Parser.g:5032:2: ( (lv_value_0_0= ruleboolean0 ) )
            // InternalRos1Parser.g:5033:3: (lv_value_0_0= ruleboolean0 )
            {
            // InternalRos1Parser.g:5033:3: (lv_value_0_0= ruleboolean0 )
            // InternalRos1Parser.g:5034:4: lv_value_0_0= ruleboolean0
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
    // InternalRos1Parser.g:5054:1: entryRuleParameterStruct returns [EObject current=null] : iv_ruleParameterStruct= ruleParameterStruct EOF ;
    public final EObject entryRuleParameterStruct() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStruct = null;


        try {
            // InternalRos1Parser.g:5054:56: (iv_ruleParameterStruct= ruleParameterStruct EOF )
            // InternalRos1Parser.g:5055:2: iv_ruleParameterStruct= ruleParameterStruct EOF
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
    // InternalRos1Parser.g:5061:1: ruleParameterStruct returns [EObject current=null] : ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? ) ;
    public final EObject ruleParameterStruct() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_BEGIN_2=null;
        Token otherlv_4=null;
        Token this_END_5=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:5067:2: ( ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? ) )
            // InternalRos1Parser.g:5068:2: ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? )
            {
            // InternalRos1Parser.g:5068:2: ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? )
            // InternalRos1Parser.g:5069:3: () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )?
            {
            // InternalRos1Parser.g:5069:3: ()
            // InternalRos1Parser.g:5070:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterStructAccess().getParameterStructAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:5076:3: (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==LeftSquareBracket) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // InternalRos1Parser.g:5077:4: otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END
                    {
                    otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_4); 

                    				newLeafNode(otherlv_1, grammarAccess.getParameterStructAccess().getLeftSquareBracketKeyword_1_0());
                    			
                    this_BEGIN_2=(Token)match(input,RULE_BEGIN,FOLLOW_68); 

                    				newLeafNode(this_BEGIN_2, grammarAccess.getParameterStructAccess().getBEGINTerminalRuleCall_1_1());
                    			
                    // InternalRos1Parser.g:5085:4: ( (lv_value_3_0= ruleParameterStructMember ) )*
                    loop94:
                    do {
                        int alt94=2;
                        int LA94_0 = input.LA(1);

                        if ( (LA94_0==Pluginslots||LA94_0==Implements||LA94_0==Parameter||LA94_0==Multiple||LA94_0==Plugins||(LA94_0>=Format && LA94_0<=Library)||(LA94_0>=Base && LA94_0<=Class)||(LA94_0>=RULE_ID && LA94_0<=RULE_STRING)) ) {
                            alt94=1;
                        }


                        switch (alt94) {
                    	case 1 :
                    	    // InternalRos1Parser.g:5086:5: (lv_value_3_0= ruleParameterStructMember )
                    	    {
                    	    // InternalRos1Parser.g:5086:5: (lv_value_3_0= ruleParameterStructMember )
                    	    // InternalRos1Parser.g:5087:6: lv_value_3_0= ruleParameterStructMember
                    	    {

                    	    						newCompositeNode(grammarAccess.getParameterStructAccess().getValueParameterStructMemberParserRuleCall_1_2_0());
                    	    					
                    	    pushFollow(FOLLOW_68);
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
                    	    break loop94;
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
    // InternalRos1Parser.g:5117:1: entryRuleParameterDate returns [EObject current=null] : iv_ruleParameterDate= ruleParameterDate EOF ;
    public final EObject entryRuleParameterDate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDate = null;


        try {
            // InternalRos1Parser.g:5117:54: (iv_ruleParameterDate= ruleParameterDate EOF )
            // InternalRos1Parser.g:5118:2: iv_ruleParameterDate= ruleParameterDate EOF
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
    // InternalRos1Parser.g:5124:1: ruleParameterDate returns [EObject current=null] : ( (lv_value_0_0= ruleDateTime0 ) ) ;
    public final EObject ruleParameterDate() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:5130:2: ( ( (lv_value_0_0= ruleDateTime0 ) ) )
            // InternalRos1Parser.g:5131:2: ( (lv_value_0_0= ruleDateTime0 ) )
            {
            // InternalRos1Parser.g:5131:2: ( (lv_value_0_0= ruleDateTime0 ) )
            // InternalRos1Parser.g:5132:3: (lv_value_0_0= ruleDateTime0 )
            {
            // InternalRos1Parser.g:5132:3: (lv_value_0_0= ruleDateTime0 )
            // InternalRos1Parser.g:5133:4: lv_value_0_0= ruleDateTime0
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
    // InternalRos1Parser.g:5153:1: entryRuleParameterStructMember returns [EObject current=null] : iv_ruleParameterStructMember= ruleParameterStructMember EOF ;
    public final EObject entryRuleParameterStructMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructMember = null;


        try {
            // InternalRos1Parser.g:5153:62: (iv_ruleParameterStructMember= ruleParameterStructMember EOF )
            // InternalRos1Parser.g:5154:2: iv_ruleParameterStructMember= ruleParameterStructMember EOF
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
    // InternalRos1Parser.g:5160:1: ruleParameterStructMember returns [EObject current=null] : ( ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) ) ( (lv_value_3_0= ruleParameterValue ) ) ) ;
    public final EObject ruleParameterStructMember() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:5166:2: ( ( ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) ) ( (lv_value_3_0= ruleParameterValue ) ) ) )
            // InternalRos1Parser.g:5167:2: ( ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) ) ( (lv_value_3_0= ruleParameterValue ) ) )
            {
            // InternalRos1Parser.g:5167:2: ( ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) ) ( (lv_value_3_0= ruleParameterValue ) ) )
            // InternalRos1Parser.g:5168:3: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) ) ( (lv_value_3_0= ruleParameterValue ) )
            {
            // InternalRos1Parser.g:5168:3: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==Library||LA96_0==Class||(LA96_0>=RULE_ID && LA96_0<=RULE_STRING)) ) {
                alt96=1;
            }
            else if ( (LA96_0==Pluginslots||LA96_0==Implements||LA96_0==Parameter||LA96_0==Multiple||LA96_0==Plugins||LA96_0==Format||LA96_0==Base) ) {
                alt96=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;
            }
            switch (alt96) {
                case 1 :
                    // InternalRos1Parser.g:5169:4: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon )
                    {
                    // InternalRos1Parser.g:5169:4: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon )
                    // InternalRos1Parser.g:5170:5: ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon
                    {
                    // InternalRos1Parser.g:5170:5: ( (lv_name_0_0= ruleEString ) )
                    // InternalRos1Parser.g:5171:6: (lv_name_0_0= ruleEString )
                    {
                    // InternalRos1Parser.g:5171:6: (lv_name_0_0= ruleEString )
                    // InternalRos1Parser.g:5172:7: lv_name_0_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getParameterStructMemberAccess().getNameEStringParserRuleCall_0_0_0_0());
                    						
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

                    otherlv_1=(Token)match(input,Colon,FOLLOW_61); 

                    					newLeafNode(otherlv_1, grammarAccess.getParameterStructMemberAccess().getColonKeyword_0_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:5195:4: ( (lv_name_2_0= ruleAddedKeywordName ) )
                    {
                    // InternalRos1Parser.g:5195:4: ( (lv_name_2_0= ruleAddedKeywordName ) )
                    // InternalRos1Parser.g:5196:5: (lv_name_2_0= ruleAddedKeywordName )
                    {
                    // InternalRos1Parser.g:5196:5: (lv_name_2_0= ruleAddedKeywordName )
                    // InternalRos1Parser.g:5197:6: lv_name_2_0= ruleAddedKeywordName
                    {

                    						newCompositeNode(grammarAccess.getParameterStructMemberAccess().getNameAddedKeywordNameParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_61);
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

            // InternalRos1Parser.g:5215:3: ( (lv_value_3_0= ruleParameterValue ) )
            // InternalRos1Parser.g:5216:4: (lv_value_3_0= ruleParameterValue )
            {
            // InternalRos1Parser.g:5216:4: (lv_value_3_0= ruleParameterValue )
            // InternalRos1Parser.g:5217:5: lv_value_3_0= ruleParameterValue
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
    // InternalRos1Parser.g:5238:1: entryRuleParameterStructTypeMember returns [EObject current=null] : iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF ;
    public final EObject entryRuleParameterStructTypeMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructTypeMember = null;


        try {
            // InternalRos1Parser.g:5238:66: (iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF )
            // InternalRos1Parser.g:5239:2: iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF
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
    // InternalRos1Parser.g:5245:1: ruleParameterStructTypeMember returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) ) ;
    public final EObject ruleParameterStructTypeMember() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_type_1_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:5251:2: ( ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) ) )
            // InternalRos1Parser.g:5252:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) )
            {
            // InternalRos1Parser.g:5252:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) )
            // InternalRos1Parser.g:5253:3: ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) )
            {
            // InternalRos1Parser.g:5253:3: ( (lv_name_0_0= ruleEString ) )
            // InternalRos1Parser.g:5254:4: (lv_name_0_0= ruleEString )
            {
            // InternalRos1Parser.g:5254:4: (lv_name_0_0= ruleEString )
            // InternalRos1Parser.g:5255:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getParameterStructTypeMemberAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_59);
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

            // InternalRos1Parser.g:5272:3: ( (lv_type_1_0= ruleParameterType ) )
            // InternalRos1Parser.g:5273:4: (lv_type_1_0= ruleParameterType )
            {
            // InternalRos1Parser.g:5273:4: (lv_type_1_0= ruleParameterType )
            // InternalRos1Parser.g:5274:5: lv_type_1_0= ruleParameterType
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
    // InternalRos1Parser.g:5295:1: entryRuleBase64Binary returns [String current=null] : iv_ruleBase64Binary= ruleBase64Binary EOF ;
    public final String entryRuleBase64Binary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBase64Binary = null;


        try {
            // InternalRos1Parser.g:5295:52: (iv_ruleBase64Binary= ruleBase64Binary EOF )
            // InternalRos1Parser.g:5296:2: iv_ruleBase64Binary= ruleBase64Binary EOF
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
    // InternalRos1Parser.g:5302:1: ruleBase64Binary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_BINARY_0= RULE_BINARY ;
    public final AntlrDatatypeRuleToken ruleBase64Binary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BINARY_0=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5308:2: (this_BINARY_0= RULE_BINARY )
            // InternalRos1Parser.g:5309:2: this_BINARY_0= RULE_BINARY
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
    // InternalRos1Parser.g:5319:1: entryRuleboolean0 returns [String current=null] : iv_ruleboolean0= ruleboolean0 EOF ;
    public final String entryRuleboolean0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleboolean0 = null;


        try {
            // InternalRos1Parser.g:5319:48: (iv_ruleboolean0= ruleboolean0 EOF )
            // InternalRos1Parser.g:5320:2: iv_ruleboolean0= ruleboolean0 EOF
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
    // InternalRos1Parser.g:5326:1: ruleboolean0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_BOOLEAN_0= RULE_BOOLEAN ;
    public final AntlrDatatypeRuleToken ruleboolean0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BOOLEAN_0=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5332:2: (this_BOOLEAN_0= RULE_BOOLEAN )
            // InternalRos1Parser.g:5333:2: this_BOOLEAN_0= RULE_BOOLEAN
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
    // InternalRos1Parser.g:5343:1: entryRuleDouble0 returns [String current=null] : iv_ruleDouble0= ruleDouble0 EOF ;
    public final String entryRuleDouble0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDouble0 = null;


        try {
            // InternalRos1Parser.g:5343:47: (iv_ruleDouble0= ruleDouble0 EOF )
            // InternalRos1Parser.g:5344:2: iv_ruleDouble0= ruleDouble0 EOF
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
    // InternalRos1Parser.g:5350:1: ruleDouble0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DOUBLE_0= RULE_DOUBLE ;
    public final AntlrDatatypeRuleToken ruleDouble0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DOUBLE_0=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5356:2: (this_DOUBLE_0= RULE_DOUBLE )
            // InternalRos1Parser.g:5357:2: this_DOUBLE_0= RULE_DOUBLE
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
    // InternalRos1Parser.g:5367:1: entryRuleInteger0 returns [String current=null] : iv_ruleInteger0= ruleInteger0 EOF ;
    public final String entryRuleInteger0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger0 = null;


        try {
            // InternalRos1Parser.g:5367:48: (iv_ruleInteger0= ruleInteger0 EOF )
            // InternalRos1Parser.g:5368:2: iv_ruleInteger0= ruleInteger0 EOF
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
    // InternalRos1Parser.g:5374:1: ruleInteger0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DECINT_0= RULE_DECINT ;
    public final AntlrDatatypeRuleToken ruleInteger0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DECINT_0=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5380:2: (this_DECINT_0= RULE_DECINT )
            // InternalRos1Parser.g:5381:2: this_DECINT_0= RULE_DECINT
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
    // InternalRos1Parser.g:5391:1: entryRuleDateTime0 returns [String current=null] : iv_ruleDateTime0= ruleDateTime0 EOF ;
    public final String entryRuleDateTime0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDateTime0 = null;


        try {
            // InternalRos1Parser.g:5391:49: (iv_ruleDateTime0= ruleDateTime0 EOF )
            // InternalRos1Parser.g:5392:2: iv_ruleDateTime0= ruleDateTime0 EOF
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
    // InternalRos1Parser.g:5398:1: ruleDateTime0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DATE_TIME_0= RULE_DATE_TIME ;
    public final AntlrDatatypeRuleToken ruleDateTime0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DATE_TIME_0=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5404:2: (this_DATE_TIME_0= RULE_DATE_TIME )
            // InternalRos1Parser.g:5405:2: this_DATE_TIME_0= RULE_DATE_TIME
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
    // InternalRos1Parser.g:5415:1: entryRuleMessagePart returns [EObject current=null] : iv_ruleMessagePart= ruleMessagePart EOF ;
    public final EObject entryRuleMessagePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessagePart = null;


        try {
            // InternalRos1Parser.g:5415:52: (iv_ruleMessagePart= ruleMessagePart EOF )
            // InternalRos1Parser.g:5416:2: iv_ruleMessagePart= ruleMessagePart EOF
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
    // InternalRos1Parser.g:5422:1: ruleMessagePart returns [EObject current=null] : ( ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) ) ) ;
    public final EObject ruleMessagePart() throws RecognitionException {
        EObject current = null;

        Token lv_Data_1_2=null;
        EObject lv_Type_0_0 = null;

        AntlrDatatypeRuleToken lv_Data_1_1 = null;

        AntlrDatatypeRuleToken lv_Data_1_3 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:5428:2: ( ( ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) ) ) )
            // InternalRos1Parser.g:5429:2: ( ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) ) )
            {
            // InternalRos1Parser.g:5429:2: ( ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) ) )
            // InternalRos1Parser.g:5430:3: ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) )
            {
            // InternalRos1Parser.g:5430:3: ( (lv_Type_0_0= ruleAbstractType ) )
            // InternalRos1Parser.g:5431:4: (lv_Type_0_0= ruleAbstractType )
            {
            // InternalRos1Parser.g:5431:4: (lv_Type_0_0= ruleAbstractType )
            // InternalRos1Parser.g:5432:5: lv_Type_0_0= ruleAbstractType
            {

            					newCompositeNode(grammarAccess.getMessagePartAccess().getTypeAbstractTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_69);
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

            // InternalRos1Parser.g:5449:3: ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) )
            // InternalRos1Parser.g:5450:4: ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) )
            {
            // InternalRos1Parser.g:5450:4: ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) )
            // InternalRos1Parser.g:5451:5: (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString )
            {
            // InternalRos1Parser.g:5451:5: (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString )
            int alt97=3;
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
                alt97=1;
                }
                break;
            case RULE_MESSAGE_ASIGMENT:
                {
                alt97=2;
                }
                break;
            case Library:
            case Class:
            case RULE_ID:
            case RULE_STRING:
                {
                alt97=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;
            }

            switch (alt97) {
                case 1 :
                    // InternalRos1Parser.g:5452:6: lv_Data_1_1= ruleKEYWORD
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
                    // InternalRos1Parser.g:5468:6: lv_Data_1_2= RULE_MESSAGE_ASIGMENT
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
                    // InternalRos1Parser.g:5483:6: lv_Data_1_3= ruleEString
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
    // InternalRos1Parser.g:5505:1: entryRuleAbstractType returns [EObject current=null] : iv_ruleAbstractType= ruleAbstractType EOF ;
    public final EObject entryRuleAbstractType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractType = null;


        try {
            // InternalRos1Parser.g:5505:53: (iv_ruleAbstractType= ruleAbstractType EOF )
            // InternalRos1Parser.g:5506:2: iv_ruleAbstractType= ruleAbstractType EOF
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
    // InternalRos1Parser.g:5512:1: ruleAbstractType returns [EObject current=null] : ( (this_ScalarType_0= ruleScalarType ( () otherlv_2= LeftSquareBracket ( (lv_bounded_3_0= LessThanSignEqualsSign ) )? ( (lv_size_4_0= ruleArraySize ) ) otherlv_5= RightSquareBracket )? ) | this_boolArray_6= ruleboolArray | this_int8Array_7= ruleint8Array | this_uint8Array_8= ruleuint8Array | this_int16Array_9= ruleint16Array | this_uint16Array_10= ruleuint16Array | this_int32Array_11= ruleint32Array | this_uint32Array_12= ruleuint32Array | this_int64Array_13= ruleint64Array | this_uint64Array_14= ruleuint64Array | this_float32Array_15= rulefloat32Array | this_float64Array_16= rulefloat64Array | this_string0Array_17= rulestring0Array | this_byteArray_18= rulebyteArray | this_ArraySpecRef_19= ruleArraySpecRef | this_charArray_20= rulecharArray ) ;
    public final EObject ruleAbstractType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_bounded_3_0=null;
        Token otherlv_5=null;
        EObject this_ScalarType_0 = null;

        AntlrDatatypeRuleToken lv_size_4_0 = null;

        EObject this_boolArray_6 = null;

        EObject this_int8Array_7 = null;

        EObject this_uint8Array_8 = null;

        EObject this_int16Array_9 = null;

        EObject this_uint16Array_10 = null;

        EObject this_int32Array_11 = null;

        EObject this_uint32Array_12 = null;

        EObject this_int64Array_13 = null;

        EObject this_uint64Array_14 = null;

        EObject this_float32Array_15 = null;

        EObject this_float64Array_16 = null;

        EObject this_string0Array_17 = null;

        EObject this_byteArray_18 = null;

        EObject this_ArraySpecRef_19 = null;

        EObject this_charArray_20 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:5518:2: ( ( (this_ScalarType_0= ruleScalarType ( () otherlv_2= LeftSquareBracket ( (lv_bounded_3_0= LessThanSignEqualsSign ) )? ( (lv_size_4_0= ruleArraySize ) ) otherlv_5= RightSquareBracket )? ) | this_boolArray_6= ruleboolArray | this_int8Array_7= ruleint8Array | this_uint8Array_8= ruleuint8Array | this_int16Array_9= ruleint16Array | this_uint16Array_10= ruleuint16Array | this_int32Array_11= ruleint32Array | this_uint32Array_12= ruleuint32Array | this_int64Array_13= ruleint64Array | this_uint64Array_14= ruleuint64Array | this_float32Array_15= rulefloat32Array | this_float64Array_16= rulefloat64Array | this_string0Array_17= rulestring0Array | this_byteArray_18= rulebyteArray | this_ArraySpecRef_19= ruleArraySpecRef | this_charArray_20= rulecharArray ) )
            // InternalRos1Parser.g:5519:2: ( (this_ScalarType_0= ruleScalarType ( () otherlv_2= LeftSquareBracket ( (lv_bounded_3_0= LessThanSignEqualsSign ) )? ( (lv_size_4_0= ruleArraySize ) ) otherlv_5= RightSquareBracket )? ) | this_boolArray_6= ruleboolArray | this_int8Array_7= ruleint8Array | this_uint8Array_8= ruleuint8Array | this_int16Array_9= ruleint16Array | this_uint16Array_10= ruleuint16Array | this_int32Array_11= ruleint32Array | this_uint32Array_12= ruleuint32Array | this_int64Array_13= ruleint64Array | this_uint64Array_14= ruleuint64Array | this_float32Array_15= rulefloat32Array | this_float64Array_16= rulefloat64Array | this_string0Array_17= rulestring0Array | this_byteArray_18= rulebyteArray | this_ArraySpecRef_19= ruleArraySpecRef | this_charArray_20= rulecharArray )
            {
            // InternalRos1Parser.g:5519:2: ( (this_ScalarType_0= ruleScalarType ( () otherlv_2= LeftSquareBracket ( (lv_bounded_3_0= LessThanSignEqualsSign ) )? ( (lv_size_4_0= ruleArraySize ) ) otherlv_5= RightSquareBracket )? ) | this_boolArray_6= ruleboolArray | this_int8Array_7= ruleint8Array | this_uint8Array_8= ruleuint8Array | this_int16Array_9= ruleint16Array | this_uint16Array_10= ruleuint16Array | this_int32Array_11= ruleint32Array | this_uint32Array_12= ruleuint32Array | this_int64Array_13= ruleint64Array | this_uint64Array_14= ruleuint64Array | this_float32Array_15= rulefloat32Array | this_float64Array_16= rulefloat64Array | this_string0Array_17= rulestring0Array | this_byteArray_18= rulebyteArray | this_ArraySpecRef_19= ruleArraySpecRef | this_charArray_20= rulecharArray )
            int alt100=16;
            alt100 = dfa100.predict(input);
            switch (alt100) {
                case 1 :
                    // InternalRos1Parser.g:5520:3: (this_ScalarType_0= ruleScalarType ( () otherlv_2= LeftSquareBracket ( (lv_bounded_3_0= LessThanSignEqualsSign ) )? ( (lv_size_4_0= ruleArraySize ) ) otherlv_5= RightSquareBracket )? )
                    {
                    // InternalRos1Parser.g:5520:3: (this_ScalarType_0= ruleScalarType ( () otherlv_2= LeftSquareBracket ( (lv_bounded_3_0= LessThanSignEqualsSign ) )? ( (lv_size_4_0= ruleArraySize ) ) otherlv_5= RightSquareBracket )? )
                    // InternalRos1Parser.g:5521:4: this_ScalarType_0= ruleScalarType ( () otherlv_2= LeftSquareBracket ( (lv_bounded_3_0= LessThanSignEqualsSign ) )? ( (lv_size_4_0= ruleArraySize ) ) otherlv_5= RightSquareBracket )?
                    {

                    				newCompositeNode(grammarAccess.getAbstractTypeAccess().getScalarTypeParserRuleCall_0_0());
                    			
                    pushFollow(FOLLOW_56);
                    this_ScalarType_0=ruleScalarType();

                    state._fsp--;


                    				current = this_ScalarType_0;
                    				afterParserOrEnumRuleCall();
                    			
                    // InternalRos1Parser.g:5529:4: ( () otherlv_2= LeftSquareBracket ( (lv_bounded_3_0= LessThanSignEqualsSign ) )? ( (lv_size_4_0= ruleArraySize ) ) otherlv_5= RightSquareBracket )?
                    int alt99=2;
                    int LA99_0 = input.LA(1);

                    if ( (LA99_0==LeftSquareBracket) ) {
                        alt99=1;
                    }
                    switch (alt99) {
                        case 1 :
                            // InternalRos1Parser.g:5530:5: () otherlv_2= LeftSquareBracket ( (lv_bounded_3_0= LessThanSignEqualsSign ) )? ( (lv_size_4_0= ruleArraySize ) ) otherlv_5= RightSquareBracket
                            {
                            // InternalRos1Parser.g:5530:5: ()
                            // InternalRos1Parser.g:5531:6: 
                            {

                            						current = forceCreateModelElementAndSet(
                            							grammarAccess.getAbstractTypeAccess().getSizedArrayElementAction_0_1_0(),
                            							current);
                            					

                            }

                            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_70); 

                            					newLeafNode(otherlv_2, grammarAccess.getAbstractTypeAccess().getLeftSquareBracketKeyword_0_1_1());
                            				
                            // InternalRos1Parser.g:5541:5: ( (lv_bounded_3_0= LessThanSignEqualsSign ) )?
                            int alt98=2;
                            int LA98_0 = input.LA(1);

                            if ( (LA98_0==LessThanSignEqualsSign) ) {
                                alt98=1;
                            }
                            switch (alt98) {
                                case 1 :
                                    // InternalRos1Parser.g:5542:6: (lv_bounded_3_0= LessThanSignEqualsSign )
                                    {
                                    // InternalRos1Parser.g:5542:6: (lv_bounded_3_0= LessThanSignEqualsSign )
                                    // InternalRos1Parser.g:5543:7: lv_bounded_3_0= LessThanSignEqualsSign
                                    {
                                    lv_bounded_3_0=(Token)match(input,LessThanSignEqualsSign,FOLLOW_70); 

                                    							newLeafNode(lv_bounded_3_0, grammarAccess.getAbstractTypeAccess().getBoundedLessThanSignEqualsSignKeyword_0_1_2_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAbstractTypeRule());
                                    							}
                                    							setWithLastConsumed(current, "bounded", lv_bounded_3_0 != null, "<=");
                                    						

                                    }


                                    }
                                    break;

                            }

                            // InternalRos1Parser.g:5555:5: ( (lv_size_4_0= ruleArraySize ) )
                            // InternalRos1Parser.g:5556:6: (lv_size_4_0= ruleArraySize )
                            {
                            // InternalRos1Parser.g:5556:6: (lv_size_4_0= ruleArraySize )
                            // InternalRos1Parser.g:5557:7: lv_size_4_0= ruleArraySize
                            {

                            							newCompositeNode(grammarAccess.getAbstractTypeAccess().getSizeArraySizeParserRuleCall_0_1_3_0());
                            						
                            pushFollow(FOLLOW_66);
                            lv_size_4_0=ruleArraySize();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getAbstractTypeRule());
                            							}
                            							set(
                            								current,
                            								"size",
                            								lv_size_4_0,
                            								"de.fraunhofer.ipa.ros.Basics.ArraySize");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_2); 

                            					newLeafNode(otherlv_5, grammarAccess.getAbstractTypeAccess().getRightSquareBracketKeyword_0_1_4());
                            				

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:5581:3: this_boolArray_6= ruleboolArray
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getBoolArrayParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_boolArray_6=ruleboolArray();

                    state._fsp--;


                    			current = this_boolArray_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRos1Parser.g:5590:3: this_int8Array_7= ruleint8Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt8ArrayParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_int8Array_7=ruleint8Array();

                    state._fsp--;


                    			current = this_int8Array_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalRos1Parser.g:5599:3: this_uint8Array_8= ruleuint8Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint8ArrayParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint8Array_8=ruleuint8Array();

                    state._fsp--;


                    			current = this_uint8Array_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalRos1Parser.g:5608:3: this_int16Array_9= ruleint16Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt16ArrayParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_int16Array_9=ruleint16Array();

                    state._fsp--;


                    			current = this_int16Array_9;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalRos1Parser.g:5617:3: this_uint16Array_10= ruleuint16Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint16ArrayParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint16Array_10=ruleuint16Array();

                    state._fsp--;


                    			current = this_uint16Array_10;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalRos1Parser.g:5626:3: this_int32Array_11= ruleint32Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt32ArrayParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_int32Array_11=ruleint32Array();

                    state._fsp--;


                    			current = this_int32Array_11;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalRos1Parser.g:5635:3: this_uint32Array_12= ruleuint32Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint32ArrayParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint32Array_12=ruleuint32Array();

                    state._fsp--;


                    			current = this_uint32Array_12;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalRos1Parser.g:5644:3: this_int64Array_13= ruleint64Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt64ArrayParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_int64Array_13=ruleint64Array();

                    state._fsp--;


                    			current = this_int64Array_13;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 10 :
                    // InternalRos1Parser.g:5653:3: this_uint64Array_14= ruleuint64Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint64ArrayParserRuleCall_9());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint64Array_14=ruleuint64Array();

                    state._fsp--;


                    			current = this_uint64Array_14;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 11 :
                    // InternalRos1Parser.g:5662:3: this_float32Array_15= rulefloat32Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getFloat32ArrayParserRuleCall_10());
                    		
                    pushFollow(FOLLOW_2);
                    this_float32Array_15=rulefloat32Array();

                    state._fsp--;


                    			current = this_float32Array_15;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 12 :
                    // InternalRos1Parser.g:5671:3: this_float64Array_16= rulefloat64Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getFloat64ArrayParserRuleCall_11());
                    		
                    pushFollow(FOLLOW_2);
                    this_float64Array_16=rulefloat64Array();

                    state._fsp--;


                    			current = this_float64Array_16;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 13 :
                    // InternalRos1Parser.g:5680:3: this_string0Array_17= rulestring0Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getString0ArrayParserRuleCall_12());
                    		
                    pushFollow(FOLLOW_2);
                    this_string0Array_17=rulestring0Array();

                    state._fsp--;


                    			current = this_string0Array_17;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 14 :
                    // InternalRos1Parser.g:5689:3: this_byteArray_18= rulebyteArray
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getByteArrayParserRuleCall_13());
                    		
                    pushFollow(FOLLOW_2);
                    this_byteArray_18=rulebyteArray();

                    state._fsp--;


                    			current = this_byteArray_18;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 15 :
                    // InternalRos1Parser.g:5698:3: this_ArraySpecRef_19= ruleArraySpecRef
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getArraySpecRefParserRuleCall_14());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArraySpecRef_19=ruleArraySpecRef();

                    state._fsp--;


                    			current = this_ArraySpecRef_19;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 16 :
                    // InternalRos1Parser.g:5707:3: this_charArray_20= rulecharArray
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getCharArrayParserRuleCall_15());
                    		
                    pushFollow(FOLLOW_2);
                    this_charArray_20=rulecharArray();

                    state._fsp--;


                    			current = this_charArray_20;
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


    // $ANTLR start "entryRuleArraySize"
    // InternalRos1Parser.g:5719:1: entryRuleArraySize returns [String current=null] : iv_ruleArraySize= ruleArraySize EOF ;
    public final String entryRuleArraySize() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleArraySize = null;


        try {
            // InternalRos1Parser.g:5719:49: (iv_ruleArraySize= ruleArraySize EOF )
            // InternalRos1Parser.g:5720:2: iv_ruleArraySize= ruleArraySize EOF
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
    // InternalRos1Parser.g:5726:1: ruleArraySize returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DECINT_0= RULE_DECINT ;
    public final AntlrDatatypeRuleToken ruleArraySize() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DECINT_0=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5732:2: (this_DECINT_0= RULE_DECINT )
            // InternalRos1Parser.g:5733:2: this_DECINT_0= RULE_DECINT
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


    // $ANTLR start "entryRuleScalarType"
    // InternalRos1Parser.g:5743:1: entryRuleScalarType returns [EObject current=null] : iv_ruleScalarType= ruleScalarType EOF ;
    public final EObject entryRuleScalarType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScalarType = null;


        try {
            // InternalRos1Parser.g:5743:51: (iv_ruleScalarType= ruleScalarType EOF )
            // InternalRos1Parser.g:5744:2: iv_ruleScalarType= ruleScalarType EOF
            {
             newCompositeNode(grammarAccess.getScalarTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScalarType=ruleScalarType();

            state._fsp--;

             current =iv_ruleScalarType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScalarType"


    // $ANTLR start "ruleScalarType"
    // InternalRos1Parser.g:5750:1: ruleScalarType returns [EObject current=null] : (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_SpecBaseRef_16= ruleSpecBaseRef | this_char_17= rulechar ) ;
    public final EObject ruleScalarType() throws RecognitionException {
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

        EObject this_SpecBaseRef_16 = null;

        EObject this_char_17 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:5756:2: ( (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_SpecBaseRef_16= ruleSpecBaseRef | this_char_17= rulechar ) )
            // InternalRos1Parser.g:5757:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_SpecBaseRef_16= ruleSpecBaseRef | this_char_17= rulechar )
            {
            // InternalRos1Parser.g:5757:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_SpecBaseRef_16= ruleSpecBaseRef | this_char_17= rulechar )
            int alt101=18;
            switch ( input.LA(1) ) {
            case Bool:
                {
                alt101=1;
                }
                break;
            case Int8:
                {
                alt101=2;
                }
                break;
            case Uint8:
                {
                alt101=3;
                }
                break;
            case Int16:
                {
                alt101=4;
                }
                break;
            case Uint16:
                {
                alt101=5;
                }
                break;
            case Int32:
                {
                alt101=6;
                }
                break;
            case Uint32:
                {
                alt101=7;
                }
                break;
            case Int64:
                {
                alt101=8;
                }
                break;
            case Uint64:
                {
                alt101=9;
                }
                break;
            case Float32:
                {
                alt101=10;
                }
                break;
            case Float64:
                {
                alt101=11;
                }
                break;
            case String_1:
                {
                alt101=12;
                }
                break;
            case Byte:
                {
                alt101=13;
                }
                break;
            case Time:
                {
                alt101=14;
                }
                break;
            case Duration:
                {
                alt101=15;
                }
                break;
            case Header:
                {
                alt101=16;
                }
                break;
            case Library:
            case Class:
            case RULE_ID:
            case RULE_STRING:
                {
                alt101=17;
                }
                break;
            case Char:
                {
                alt101=18;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;
            }

            switch (alt101) {
                case 1 :
                    // InternalRos1Parser.g:5758:3: this_bool_0= rulebool
                    {

                    			newCompositeNode(grammarAccess.getScalarTypeAccess().getBoolParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_bool_0=rulebool();

                    state._fsp--;


                    			current = this_bool_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:5767:3: this_int8_1= ruleint8
                    {

                    			newCompositeNode(grammarAccess.getScalarTypeAccess().getInt8ParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_int8_1=ruleint8();

                    state._fsp--;


                    			current = this_int8_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRos1Parser.g:5776:3: this_uint8_2= ruleuint8
                    {

                    			newCompositeNode(grammarAccess.getScalarTypeAccess().getUint8ParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint8_2=ruleuint8();

                    state._fsp--;


                    			current = this_uint8_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalRos1Parser.g:5785:3: this_int16_3= ruleint16
                    {

                    			newCompositeNode(grammarAccess.getScalarTypeAccess().getInt16ParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_int16_3=ruleint16();

                    state._fsp--;


                    			current = this_int16_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalRos1Parser.g:5794:3: this_uint16_4= ruleuint16
                    {

                    			newCompositeNode(grammarAccess.getScalarTypeAccess().getUint16ParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint16_4=ruleuint16();

                    state._fsp--;


                    			current = this_uint16_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalRos1Parser.g:5803:3: this_int32_5= ruleint32
                    {

                    			newCompositeNode(grammarAccess.getScalarTypeAccess().getInt32ParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_int32_5=ruleint32();

                    state._fsp--;


                    			current = this_int32_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalRos1Parser.g:5812:3: this_uint32_6= ruleuint32
                    {

                    			newCompositeNode(grammarAccess.getScalarTypeAccess().getUint32ParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint32_6=ruleuint32();

                    state._fsp--;


                    			current = this_uint32_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalRos1Parser.g:5821:3: this_int64_7= ruleint64
                    {

                    			newCompositeNode(grammarAccess.getScalarTypeAccess().getInt64ParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_int64_7=ruleint64();

                    state._fsp--;


                    			current = this_int64_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalRos1Parser.g:5830:3: this_uint64_8= ruleuint64
                    {

                    			newCompositeNode(grammarAccess.getScalarTypeAccess().getUint64ParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint64_8=ruleuint64();

                    state._fsp--;


                    			current = this_uint64_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 10 :
                    // InternalRos1Parser.g:5839:3: this_float32_9= rulefloat32
                    {

                    			newCompositeNode(grammarAccess.getScalarTypeAccess().getFloat32ParserRuleCall_9());
                    		
                    pushFollow(FOLLOW_2);
                    this_float32_9=rulefloat32();

                    state._fsp--;


                    			current = this_float32_9;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 11 :
                    // InternalRos1Parser.g:5848:3: this_float64_10= rulefloat64
                    {

                    			newCompositeNode(grammarAccess.getScalarTypeAccess().getFloat64ParserRuleCall_10());
                    		
                    pushFollow(FOLLOW_2);
                    this_float64_10=rulefloat64();

                    state._fsp--;


                    			current = this_float64_10;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 12 :
                    // InternalRos1Parser.g:5857:3: this_string0_11= rulestring0
                    {

                    			newCompositeNode(grammarAccess.getScalarTypeAccess().getString0ParserRuleCall_11());
                    		
                    pushFollow(FOLLOW_2);
                    this_string0_11=rulestring0();

                    state._fsp--;


                    			current = this_string0_11;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 13 :
                    // InternalRos1Parser.g:5866:3: this_byte_12= rulebyte
                    {

                    			newCompositeNode(grammarAccess.getScalarTypeAccess().getByteParserRuleCall_12());
                    		
                    pushFollow(FOLLOW_2);
                    this_byte_12=rulebyte();

                    state._fsp--;


                    			current = this_byte_12;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 14 :
                    // InternalRos1Parser.g:5875:3: this_time_13= ruletime
                    {

                    			newCompositeNode(grammarAccess.getScalarTypeAccess().getTimeParserRuleCall_13());
                    		
                    pushFollow(FOLLOW_2);
                    this_time_13=ruletime();

                    state._fsp--;


                    			current = this_time_13;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 15 :
                    // InternalRos1Parser.g:5884:3: this_duration_14= ruleduration
                    {

                    			newCompositeNode(grammarAccess.getScalarTypeAccess().getDurationParserRuleCall_14());
                    		
                    pushFollow(FOLLOW_2);
                    this_duration_14=ruleduration();

                    state._fsp--;


                    			current = this_duration_14;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 16 :
                    // InternalRos1Parser.g:5893:3: this_Header_15= ruleHeader
                    {

                    			newCompositeNode(grammarAccess.getScalarTypeAccess().getHeaderParserRuleCall_15());
                    		
                    pushFollow(FOLLOW_2);
                    this_Header_15=ruleHeader();

                    state._fsp--;


                    			current = this_Header_15;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 17 :
                    // InternalRos1Parser.g:5902:3: this_SpecBaseRef_16= ruleSpecBaseRef
                    {

                    			newCompositeNode(grammarAccess.getScalarTypeAccess().getSpecBaseRefParserRuleCall_16());
                    		
                    pushFollow(FOLLOW_2);
                    this_SpecBaseRef_16=ruleSpecBaseRef();

                    state._fsp--;


                    			current = this_SpecBaseRef_16;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 18 :
                    // InternalRos1Parser.g:5911:3: this_char_17= rulechar
                    {

                    			newCompositeNode(grammarAccess.getScalarTypeAccess().getCharParserRuleCall_17());
                    		
                    pushFollow(FOLLOW_2);
                    this_char_17=rulechar();

                    state._fsp--;


                    			current = this_char_17;
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
    // $ANTLR end "ruleScalarType"


    // $ANTLR start "entryRulebool"
    // InternalRos1Parser.g:5923:1: entryRulebool returns [EObject current=null] : iv_rulebool= rulebool EOF ;
    public final EObject entryRulebool() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebool = null;


        try {
            // InternalRos1Parser.g:5923:45: (iv_rulebool= rulebool EOF )
            // InternalRos1Parser.g:5924:2: iv_rulebool= rulebool EOF
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
    // InternalRos1Parser.g:5930:1: rulebool returns [EObject current=null] : ( () otherlv_1= Bool ) ;
    public final EObject rulebool() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5936:2: ( ( () otherlv_1= Bool ) )
            // InternalRos1Parser.g:5937:2: ( () otherlv_1= Bool )
            {
            // InternalRos1Parser.g:5937:2: ( () otherlv_1= Bool )
            // InternalRos1Parser.g:5938:3: () otherlv_1= Bool
            {
            // InternalRos1Parser.g:5938:3: ()
            // InternalRos1Parser.g:5939:4: 
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
    // InternalRos1Parser.g:5953:1: entryRuleint8 returns [EObject current=null] : iv_ruleint8= ruleint8 EOF ;
    public final EObject entryRuleint8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint8 = null;


        try {
            // InternalRos1Parser.g:5953:45: (iv_ruleint8= ruleint8 EOF )
            // InternalRos1Parser.g:5954:2: iv_ruleint8= ruleint8 EOF
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
    // InternalRos1Parser.g:5960:1: ruleint8 returns [EObject current=null] : ( () otherlv_1= Int8 ) ;
    public final EObject ruleint8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5966:2: ( ( () otherlv_1= Int8 ) )
            // InternalRos1Parser.g:5967:2: ( () otherlv_1= Int8 )
            {
            // InternalRos1Parser.g:5967:2: ( () otherlv_1= Int8 )
            // InternalRos1Parser.g:5968:3: () otherlv_1= Int8
            {
            // InternalRos1Parser.g:5968:3: ()
            // InternalRos1Parser.g:5969:4: 
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
    // InternalRos1Parser.g:5983:1: entryRuleuint8 returns [EObject current=null] : iv_ruleuint8= ruleuint8 EOF ;
    public final EObject entryRuleuint8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint8 = null;


        try {
            // InternalRos1Parser.g:5983:46: (iv_ruleuint8= ruleuint8 EOF )
            // InternalRos1Parser.g:5984:2: iv_ruleuint8= ruleuint8 EOF
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
    // InternalRos1Parser.g:5990:1: ruleuint8 returns [EObject current=null] : ( () otherlv_1= Uint8 ) ;
    public final EObject ruleuint8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5996:2: ( ( () otherlv_1= Uint8 ) )
            // InternalRos1Parser.g:5997:2: ( () otherlv_1= Uint8 )
            {
            // InternalRos1Parser.g:5997:2: ( () otherlv_1= Uint8 )
            // InternalRos1Parser.g:5998:3: () otherlv_1= Uint8
            {
            // InternalRos1Parser.g:5998:3: ()
            // InternalRos1Parser.g:5999:4: 
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
    // InternalRos1Parser.g:6013:1: entryRuleint16 returns [EObject current=null] : iv_ruleint16= ruleint16 EOF ;
    public final EObject entryRuleint16() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint16 = null;


        try {
            // InternalRos1Parser.g:6013:46: (iv_ruleint16= ruleint16 EOF )
            // InternalRos1Parser.g:6014:2: iv_ruleint16= ruleint16 EOF
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
    // InternalRos1Parser.g:6020:1: ruleint16 returns [EObject current=null] : ( () otherlv_1= Int16 ) ;
    public final EObject ruleint16() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6026:2: ( ( () otherlv_1= Int16 ) )
            // InternalRos1Parser.g:6027:2: ( () otherlv_1= Int16 )
            {
            // InternalRos1Parser.g:6027:2: ( () otherlv_1= Int16 )
            // InternalRos1Parser.g:6028:3: () otherlv_1= Int16
            {
            // InternalRos1Parser.g:6028:3: ()
            // InternalRos1Parser.g:6029:4: 
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
    // InternalRos1Parser.g:6043:1: entryRuleuint16 returns [EObject current=null] : iv_ruleuint16= ruleuint16 EOF ;
    public final EObject entryRuleuint16() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint16 = null;


        try {
            // InternalRos1Parser.g:6043:47: (iv_ruleuint16= ruleuint16 EOF )
            // InternalRos1Parser.g:6044:2: iv_ruleuint16= ruleuint16 EOF
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
    // InternalRos1Parser.g:6050:1: ruleuint16 returns [EObject current=null] : ( () otherlv_1= Uint16 ) ;
    public final EObject ruleuint16() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6056:2: ( ( () otherlv_1= Uint16 ) )
            // InternalRos1Parser.g:6057:2: ( () otherlv_1= Uint16 )
            {
            // InternalRos1Parser.g:6057:2: ( () otherlv_1= Uint16 )
            // InternalRos1Parser.g:6058:3: () otherlv_1= Uint16
            {
            // InternalRos1Parser.g:6058:3: ()
            // InternalRos1Parser.g:6059:4: 
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
    // InternalRos1Parser.g:6073:1: entryRuleint32 returns [EObject current=null] : iv_ruleint32= ruleint32 EOF ;
    public final EObject entryRuleint32() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint32 = null;


        try {
            // InternalRos1Parser.g:6073:46: (iv_ruleint32= ruleint32 EOF )
            // InternalRos1Parser.g:6074:2: iv_ruleint32= ruleint32 EOF
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
    // InternalRos1Parser.g:6080:1: ruleint32 returns [EObject current=null] : ( () otherlv_1= Int32 ) ;
    public final EObject ruleint32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6086:2: ( ( () otherlv_1= Int32 ) )
            // InternalRos1Parser.g:6087:2: ( () otherlv_1= Int32 )
            {
            // InternalRos1Parser.g:6087:2: ( () otherlv_1= Int32 )
            // InternalRos1Parser.g:6088:3: () otherlv_1= Int32
            {
            // InternalRos1Parser.g:6088:3: ()
            // InternalRos1Parser.g:6089:4: 
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
    // InternalRos1Parser.g:6103:1: entryRuleuint32 returns [EObject current=null] : iv_ruleuint32= ruleuint32 EOF ;
    public final EObject entryRuleuint32() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint32 = null;


        try {
            // InternalRos1Parser.g:6103:47: (iv_ruleuint32= ruleuint32 EOF )
            // InternalRos1Parser.g:6104:2: iv_ruleuint32= ruleuint32 EOF
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
    // InternalRos1Parser.g:6110:1: ruleuint32 returns [EObject current=null] : ( () otherlv_1= Uint32 ) ;
    public final EObject ruleuint32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6116:2: ( ( () otherlv_1= Uint32 ) )
            // InternalRos1Parser.g:6117:2: ( () otherlv_1= Uint32 )
            {
            // InternalRos1Parser.g:6117:2: ( () otherlv_1= Uint32 )
            // InternalRos1Parser.g:6118:3: () otherlv_1= Uint32
            {
            // InternalRos1Parser.g:6118:3: ()
            // InternalRos1Parser.g:6119:4: 
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
    // InternalRos1Parser.g:6133:1: entryRuleint64 returns [EObject current=null] : iv_ruleint64= ruleint64 EOF ;
    public final EObject entryRuleint64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint64 = null;


        try {
            // InternalRos1Parser.g:6133:46: (iv_ruleint64= ruleint64 EOF )
            // InternalRos1Parser.g:6134:2: iv_ruleint64= ruleint64 EOF
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
    // InternalRos1Parser.g:6140:1: ruleint64 returns [EObject current=null] : ( () otherlv_1= Int64 ) ;
    public final EObject ruleint64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6146:2: ( ( () otherlv_1= Int64 ) )
            // InternalRos1Parser.g:6147:2: ( () otherlv_1= Int64 )
            {
            // InternalRos1Parser.g:6147:2: ( () otherlv_1= Int64 )
            // InternalRos1Parser.g:6148:3: () otherlv_1= Int64
            {
            // InternalRos1Parser.g:6148:3: ()
            // InternalRos1Parser.g:6149:4: 
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
    // InternalRos1Parser.g:6163:1: entryRuleuint64 returns [EObject current=null] : iv_ruleuint64= ruleuint64 EOF ;
    public final EObject entryRuleuint64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint64 = null;


        try {
            // InternalRos1Parser.g:6163:47: (iv_ruleuint64= ruleuint64 EOF )
            // InternalRos1Parser.g:6164:2: iv_ruleuint64= ruleuint64 EOF
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
    // InternalRos1Parser.g:6170:1: ruleuint64 returns [EObject current=null] : ( () otherlv_1= Uint64 ) ;
    public final EObject ruleuint64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6176:2: ( ( () otherlv_1= Uint64 ) )
            // InternalRos1Parser.g:6177:2: ( () otherlv_1= Uint64 )
            {
            // InternalRos1Parser.g:6177:2: ( () otherlv_1= Uint64 )
            // InternalRos1Parser.g:6178:3: () otherlv_1= Uint64
            {
            // InternalRos1Parser.g:6178:3: ()
            // InternalRos1Parser.g:6179:4: 
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
    // InternalRos1Parser.g:6193:1: entryRulefloat32 returns [EObject current=null] : iv_rulefloat32= rulefloat32 EOF ;
    public final EObject entryRulefloat32() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat32 = null;


        try {
            // InternalRos1Parser.g:6193:48: (iv_rulefloat32= rulefloat32 EOF )
            // InternalRos1Parser.g:6194:2: iv_rulefloat32= rulefloat32 EOF
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
    // InternalRos1Parser.g:6200:1: rulefloat32 returns [EObject current=null] : ( () otherlv_1= Float32 ) ;
    public final EObject rulefloat32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6206:2: ( ( () otherlv_1= Float32 ) )
            // InternalRos1Parser.g:6207:2: ( () otherlv_1= Float32 )
            {
            // InternalRos1Parser.g:6207:2: ( () otherlv_1= Float32 )
            // InternalRos1Parser.g:6208:3: () otherlv_1= Float32
            {
            // InternalRos1Parser.g:6208:3: ()
            // InternalRos1Parser.g:6209:4: 
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
    // InternalRos1Parser.g:6223:1: entryRulefloat64 returns [EObject current=null] : iv_rulefloat64= rulefloat64 EOF ;
    public final EObject entryRulefloat64() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat64 = null;


        try {
            // InternalRos1Parser.g:6223:48: (iv_rulefloat64= rulefloat64 EOF )
            // InternalRos1Parser.g:6224:2: iv_rulefloat64= rulefloat64 EOF
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
    // InternalRos1Parser.g:6230:1: rulefloat64 returns [EObject current=null] : ( () otherlv_1= Float64 ) ;
    public final EObject rulefloat64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6236:2: ( ( () otherlv_1= Float64 ) )
            // InternalRos1Parser.g:6237:2: ( () otherlv_1= Float64 )
            {
            // InternalRos1Parser.g:6237:2: ( () otherlv_1= Float64 )
            // InternalRos1Parser.g:6238:3: () otherlv_1= Float64
            {
            // InternalRos1Parser.g:6238:3: ()
            // InternalRos1Parser.g:6239:4: 
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
    // InternalRos1Parser.g:6253:1: entryRulestring0 returns [EObject current=null] : iv_rulestring0= rulestring0 EOF ;
    public final EObject entryRulestring0() throws RecognitionException {
        EObject current = null;

        EObject iv_rulestring0 = null;


        try {
            // InternalRos1Parser.g:6253:48: (iv_rulestring0= rulestring0 EOF )
            // InternalRos1Parser.g:6254:2: iv_rulestring0= rulestring0 EOF
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
    // InternalRos1Parser.g:6260:1: rulestring0 returns [EObject current=null] : ( () otherlv_1= String_1 ) ;
    public final EObject rulestring0() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6266:2: ( ( () otherlv_1= String_1 ) )
            // InternalRos1Parser.g:6267:2: ( () otherlv_1= String_1 )
            {
            // InternalRos1Parser.g:6267:2: ( () otherlv_1= String_1 )
            // InternalRos1Parser.g:6268:3: () otherlv_1= String_1
            {
            // InternalRos1Parser.g:6268:3: ()
            // InternalRos1Parser.g:6269:4: 
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
    // InternalRos1Parser.g:6283:1: entryRulechar returns [EObject current=null] : iv_rulechar= rulechar EOF ;
    public final EObject entryRulechar() throws RecognitionException {
        EObject current = null;

        EObject iv_rulechar = null;


        try {
            // InternalRos1Parser.g:6283:45: (iv_rulechar= rulechar EOF )
            // InternalRos1Parser.g:6284:2: iv_rulechar= rulechar EOF
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
    // InternalRos1Parser.g:6290:1: rulechar returns [EObject current=null] : ( () otherlv_1= Char ) ;
    public final EObject rulechar() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6296:2: ( ( () otherlv_1= Char ) )
            // InternalRos1Parser.g:6297:2: ( () otherlv_1= Char )
            {
            // InternalRos1Parser.g:6297:2: ( () otherlv_1= Char )
            // InternalRos1Parser.g:6298:3: () otherlv_1= Char
            {
            // InternalRos1Parser.g:6298:3: ()
            // InternalRos1Parser.g:6299:4: 
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
    // InternalRos1Parser.g:6313:1: entryRulebyte returns [EObject current=null] : iv_rulebyte= rulebyte EOF ;
    public final EObject entryRulebyte() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebyte = null;


        try {
            // InternalRos1Parser.g:6313:45: (iv_rulebyte= rulebyte EOF )
            // InternalRos1Parser.g:6314:2: iv_rulebyte= rulebyte EOF
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
    // InternalRos1Parser.g:6320:1: rulebyte returns [EObject current=null] : ( () otherlv_1= Byte ) ;
    public final EObject rulebyte() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6326:2: ( ( () otherlv_1= Byte ) )
            // InternalRos1Parser.g:6327:2: ( () otherlv_1= Byte )
            {
            // InternalRos1Parser.g:6327:2: ( () otherlv_1= Byte )
            // InternalRos1Parser.g:6328:3: () otherlv_1= Byte
            {
            // InternalRos1Parser.g:6328:3: ()
            // InternalRos1Parser.g:6329:4: 
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
    // InternalRos1Parser.g:6343:1: entryRuletime returns [EObject current=null] : iv_ruletime= ruletime EOF ;
    public final EObject entryRuletime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletime = null;


        try {
            // InternalRos1Parser.g:6343:45: (iv_ruletime= ruletime EOF )
            // InternalRos1Parser.g:6344:2: iv_ruletime= ruletime EOF
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
    // InternalRos1Parser.g:6350:1: ruletime returns [EObject current=null] : ( () otherlv_1= Time ) ;
    public final EObject ruletime() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6356:2: ( ( () otherlv_1= Time ) )
            // InternalRos1Parser.g:6357:2: ( () otherlv_1= Time )
            {
            // InternalRos1Parser.g:6357:2: ( () otherlv_1= Time )
            // InternalRos1Parser.g:6358:3: () otherlv_1= Time
            {
            // InternalRos1Parser.g:6358:3: ()
            // InternalRos1Parser.g:6359:4: 
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
    // InternalRos1Parser.g:6373:1: entryRuleduration returns [EObject current=null] : iv_ruleduration= ruleduration EOF ;
    public final EObject entryRuleduration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleduration = null;


        try {
            // InternalRos1Parser.g:6373:49: (iv_ruleduration= ruleduration EOF )
            // InternalRos1Parser.g:6374:2: iv_ruleduration= ruleduration EOF
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
    // InternalRos1Parser.g:6380:1: ruleduration returns [EObject current=null] : ( () otherlv_1= Duration ) ;
    public final EObject ruleduration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6386:2: ( ( () otherlv_1= Duration ) )
            // InternalRos1Parser.g:6387:2: ( () otherlv_1= Duration )
            {
            // InternalRos1Parser.g:6387:2: ( () otherlv_1= Duration )
            // InternalRos1Parser.g:6388:3: () otherlv_1= Duration
            {
            // InternalRos1Parser.g:6388:3: ()
            // InternalRos1Parser.g:6389:4: 
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
    // InternalRos1Parser.g:6403:1: entryRuleboolArray returns [EObject current=null] : iv_ruleboolArray= ruleboolArray EOF ;
    public final EObject entryRuleboolArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleboolArray = null;


        try {
            // InternalRos1Parser.g:6403:50: (iv_ruleboolArray= ruleboolArray EOF )
            // InternalRos1Parser.g:6404:2: iv_ruleboolArray= ruleboolArray EOF
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
    // InternalRos1Parser.g:6410:1: ruleboolArray returns [EObject current=null] : ( () otherlv_1= Bool otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) ;
    public final EObject ruleboolArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6416:2: ( ( () otherlv_1= Bool otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) )
            // InternalRos1Parser.g:6417:2: ( () otherlv_1= Bool otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            {
            // InternalRos1Parser.g:6417:2: ( () otherlv_1= Bool otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            // InternalRos1Parser.g:6418:3: () otherlv_1= Bool otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket
            {
            // InternalRos1Parser.g:6418:3: ()
            // InternalRos1Parser.g:6419:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBoolArrayAccess().getBoolArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Bool,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getBoolArrayAccess().getBoolKeyword_1());
            		
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_66); 

            			newLeafNode(otherlv_2, grammarAccess.getBoolArrayAccess().getLeftSquareBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,RightSquareBracket,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getBoolArrayAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

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
    // InternalRos1Parser.g:6441:1: entryRuleint8Array returns [EObject current=null] : iv_ruleint8Array= ruleint8Array EOF ;
    public final EObject entryRuleint8Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint8Array = null;


        try {
            // InternalRos1Parser.g:6441:50: (iv_ruleint8Array= ruleint8Array EOF )
            // InternalRos1Parser.g:6442:2: iv_ruleint8Array= ruleint8Array EOF
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
    // InternalRos1Parser.g:6448:1: ruleint8Array returns [EObject current=null] : ( () otherlv_1= Int8 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) ;
    public final EObject ruleint8Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6454:2: ( ( () otherlv_1= Int8 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) )
            // InternalRos1Parser.g:6455:2: ( () otherlv_1= Int8 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            {
            // InternalRos1Parser.g:6455:2: ( () otherlv_1= Int8 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            // InternalRos1Parser.g:6456:3: () otherlv_1= Int8 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket
            {
            // InternalRos1Parser.g:6456:3: ()
            // InternalRos1Parser.g:6457:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInt8ArrayAccess().getInt8ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int8,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getInt8ArrayAccess().getInt8Keyword_1());
            		
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_66); 

            			newLeafNode(otherlv_2, grammarAccess.getInt8ArrayAccess().getLeftSquareBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,RightSquareBracket,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getInt8ArrayAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

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
    // InternalRos1Parser.g:6479:1: entryRuleuint8Array returns [EObject current=null] : iv_ruleuint8Array= ruleuint8Array EOF ;
    public final EObject entryRuleuint8Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint8Array = null;


        try {
            // InternalRos1Parser.g:6479:51: (iv_ruleuint8Array= ruleuint8Array EOF )
            // InternalRos1Parser.g:6480:2: iv_ruleuint8Array= ruleuint8Array EOF
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
    // InternalRos1Parser.g:6486:1: ruleuint8Array returns [EObject current=null] : ( () otherlv_1= Uint8 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) ;
    public final EObject ruleuint8Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6492:2: ( ( () otherlv_1= Uint8 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) )
            // InternalRos1Parser.g:6493:2: ( () otherlv_1= Uint8 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            {
            // InternalRos1Parser.g:6493:2: ( () otherlv_1= Uint8 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            // InternalRos1Parser.g:6494:3: () otherlv_1= Uint8 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket
            {
            // InternalRos1Parser.g:6494:3: ()
            // InternalRos1Parser.g:6495:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUint8ArrayAccess().getUint8ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint8,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getUint8ArrayAccess().getUint8Keyword_1());
            		
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_66); 

            			newLeafNode(otherlv_2, grammarAccess.getUint8ArrayAccess().getLeftSquareBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,RightSquareBracket,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getUint8ArrayAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

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
    // InternalRos1Parser.g:6517:1: entryRuleint16Array returns [EObject current=null] : iv_ruleint16Array= ruleint16Array EOF ;
    public final EObject entryRuleint16Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint16Array = null;


        try {
            // InternalRos1Parser.g:6517:51: (iv_ruleint16Array= ruleint16Array EOF )
            // InternalRos1Parser.g:6518:2: iv_ruleint16Array= ruleint16Array EOF
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
    // InternalRos1Parser.g:6524:1: ruleint16Array returns [EObject current=null] : ( () otherlv_1= Int16 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) ;
    public final EObject ruleint16Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6530:2: ( ( () otherlv_1= Int16 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) )
            // InternalRos1Parser.g:6531:2: ( () otherlv_1= Int16 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            {
            // InternalRos1Parser.g:6531:2: ( () otherlv_1= Int16 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            // InternalRos1Parser.g:6532:3: () otherlv_1= Int16 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket
            {
            // InternalRos1Parser.g:6532:3: ()
            // InternalRos1Parser.g:6533:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInt16ArrayAccess().getInt16ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int16,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getInt16ArrayAccess().getInt16Keyword_1());
            		
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_66); 

            			newLeafNode(otherlv_2, grammarAccess.getInt16ArrayAccess().getLeftSquareBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,RightSquareBracket,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getInt16ArrayAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

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
    // InternalRos1Parser.g:6555:1: entryRuleuint16Array returns [EObject current=null] : iv_ruleuint16Array= ruleuint16Array EOF ;
    public final EObject entryRuleuint16Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint16Array = null;


        try {
            // InternalRos1Parser.g:6555:52: (iv_ruleuint16Array= ruleuint16Array EOF )
            // InternalRos1Parser.g:6556:2: iv_ruleuint16Array= ruleuint16Array EOF
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
    // InternalRos1Parser.g:6562:1: ruleuint16Array returns [EObject current=null] : ( () otherlv_1= Uint16 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) ;
    public final EObject ruleuint16Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6568:2: ( ( () otherlv_1= Uint16 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) )
            // InternalRos1Parser.g:6569:2: ( () otherlv_1= Uint16 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            {
            // InternalRos1Parser.g:6569:2: ( () otherlv_1= Uint16 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            // InternalRos1Parser.g:6570:3: () otherlv_1= Uint16 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket
            {
            // InternalRos1Parser.g:6570:3: ()
            // InternalRos1Parser.g:6571:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUint16ArrayAccess().getUint16ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint16,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getUint16ArrayAccess().getUint16Keyword_1());
            		
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_66); 

            			newLeafNode(otherlv_2, grammarAccess.getUint16ArrayAccess().getLeftSquareBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,RightSquareBracket,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getUint16ArrayAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

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
    // InternalRos1Parser.g:6593:1: entryRuleint32Array returns [EObject current=null] : iv_ruleint32Array= ruleint32Array EOF ;
    public final EObject entryRuleint32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint32Array = null;


        try {
            // InternalRos1Parser.g:6593:51: (iv_ruleint32Array= ruleint32Array EOF )
            // InternalRos1Parser.g:6594:2: iv_ruleint32Array= ruleint32Array EOF
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
    // InternalRos1Parser.g:6600:1: ruleint32Array returns [EObject current=null] : ( () otherlv_1= Int32 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) ;
    public final EObject ruleint32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6606:2: ( ( () otherlv_1= Int32 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) )
            // InternalRos1Parser.g:6607:2: ( () otherlv_1= Int32 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            {
            // InternalRos1Parser.g:6607:2: ( () otherlv_1= Int32 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            // InternalRos1Parser.g:6608:3: () otherlv_1= Int32 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket
            {
            // InternalRos1Parser.g:6608:3: ()
            // InternalRos1Parser.g:6609:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInt32ArrayAccess().getInt32ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int32,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getInt32ArrayAccess().getInt32Keyword_1());
            		
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_66); 

            			newLeafNode(otherlv_2, grammarAccess.getInt32ArrayAccess().getLeftSquareBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,RightSquareBracket,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getInt32ArrayAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

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
    // InternalRos1Parser.g:6631:1: entryRuleuint32Array returns [EObject current=null] : iv_ruleuint32Array= ruleuint32Array EOF ;
    public final EObject entryRuleuint32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint32Array = null;


        try {
            // InternalRos1Parser.g:6631:52: (iv_ruleuint32Array= ruleuint32Array EOF )
            // InternalRos1Parser.g:6632:2: iv_ruleuint32Array= ruleuint32Array EOF
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
    // InternalRos1Parser.g:6638:1: ruleuint32Array returns [EObject current=null] : ( () otherlv_1= Uint32 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) ;
    public final EObject ruleuint32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6644:2: ( ( () otherlv_1= Uint32 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) )
            // InternalRos1Parser.g:6645:2: ( () otherlv_1= Uint32 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            {
            // InternalRos1Parser.g:6645:2: ( () otherlv_1= Uint32 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            // InternalRos1Parser.g:6646:3: () otherlv_1= Uint32 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket
            {
            // InternalRos1Parser.g:6646:3: ()
            // InternalRos1Parser.g:6647:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUint32ArrayAccess().getUint32ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint32,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getUint32ArrayAccess().getUint32Keyword_1());
            		
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_66); 

            			newLeafNode(otherlv_2, grammarAccess.getUint32ArrayAccess().getLeftSquareBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,RightSquareBracket,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getUint32ArrayAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

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
    // InternalRos1Parser.g:6669:1: entryRuleint64Array returns [EObject current=null] : iv_ruleint64Array= ruleint64Array EOF ;
    public final EObject entryRuleint64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint64Array = null;


        try {
            // InternalRos1Parser.g:6669:51: (iv_ruleint64Array= ruleint64Array EOF )
            // InternalRos1Parser.g:6670:2: iv_ruleint64Array= ruleint64Array EOF
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
    // InternalRos1Parser.g:6676:1: ruleint64Array returns [EObject current=null] : ( () otherlv_1= Int64 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) ;
    public final EObject ruleint64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6682:2: ( ( () otherlv_1= Int64 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) )
            // InternalRos1Parser.g:6683:2: ( () otherlv_1= Int64 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            {
            // InternalRos1Parser.g:6683:2: ( () otherlv_1= Int64 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            // InternalRos1Parser.g:6684:3: () otherlv_1= Int64 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket
            {
            // InternalRos1Parser.g:6684:3: ()
            // InternalRos1Parser.g:6685:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInt64ArrayAccess().getInt64ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int64,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getInt64ArrayAccess().getInt64Keyword_1());
            		
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_66); 

            			newLeafNode(otherlv_2, grammarAccess.getInt64ArrayAccess().getLeftSquareBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,RightSquareBracket,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getInt64ArrayAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

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
    // InternalRos1Parser.g:6707:1: entryRuleuint64Array returns [EObject current=null] : iv_ruleuint64Array= ruleuint64Array EOF ;
    public final EObject entryRuleuint64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint64Array = null;


        try {
            // InternalRos1Parser.g:6707:52: (iv_ruleuint64Array= ruleuint64Array EOF )
            // InternalRos1Parser.g:6708:2: iv_ruleuint64Array= ruleuint64Array EOF
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
    // InternalRos1Parser.g:6714:1: ruleuint64Array returns [EObject current=null] : ( () otherlv_1= Uint64 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) ;
    public final EObject ruleuint64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6720:2: ( ( () otherlv_1= Uint64 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) )
            // InternalRos1Parser.g:6721:2: ( () otherlv_1= Uint64 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            {
            // InternalRos1Parser.g:6721:2: ( () otherlv_1= Uint64 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            // InternalRos1Parser.g:6722:3: () otherlv_1= Uint64 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket
            {
            // InternalRos1Parser.g:6722:3: ()
            // InternalRos1Parser.g:6723:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUint64ArrayAccess().getUint64ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint64,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getUint64ArrayAccess().getUint64Keyword_1());
            		
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_66); 

            			newLeafNode(otherlv_2, grammarAccess.getUint64ArrayAccess().getLeftSquareBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,RightSquareBracket,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getUint64ArrayAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

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
    // InternalRos1Parser.g:6745:1: entryRulefloat32Array returns [EObject current=null] : iv_rulefloat32Array= rulefloat32Array EOF ;
    public final EObject entryRulefloat32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat32Array = null;


        try {
            // InternalRos1Parser.g:6745:53: (iv_rulefloat32Array= rulefloat32Array EOF )
            // InternalRos1Parser.g:6746:2: iv_rulefloat32Array= rulefloat32Array EOF
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
    // InternalRos1Parser.g:6752:1: rulefloat32Array returns [EObject current=null] : ( () otherlv_1= Float32 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) ;
    public final EObject rulefloat32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6758:2: ( ( () otherlv_1= Float32 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) )
            // InternalRos1Parser.g:6759:2: ( () otherlv_1= Float32 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            {
            // InternalRos1Parser.g:6759:2: ( () otherlv_1= Float32 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            // InternalRos1Parser.g:6760:3: () otherlv_1= Float32 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket
            {
            // InternalRos1Parser.g:6760:3: ()
            // InternalRos1Parser.g:6761:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFloat32ArrayAccess().getFloat32ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Float32,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getFloat32ArrayAccess().getFloat32Keyword_1());
            		
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_66); 

            			newLeafNode(otherlv_2, grammarAccess.getFloat32ArrayAccess().getLeftSquareBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,RightSquareBracket,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getFloat32ArrayAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

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
    // InternalRos1Parser.g:6783:1: entryRulefloat64Array returns [EObject current=null] : iv_rulefloat64Array= rulefloat64Array EOF ;
    public final EObject entryRulefloat64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat64Array = null;


        try {
            // InternalRos1Parser.g:6783:53: (iv_rulefloat64Array= rulefloat64Array EOF )
            // InternalRos1Parser.g:6784:2: iv_rulefloat64Array= rulefloat64Array EOF
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
    // InternalRos1Parser.g:6790:1: rulefloat64Array returns [EObject current=null] : ( () otherlv_1= Float64 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) ;
    public final EObject rulefloat64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6796:2: ( ( () otherlv_1= Float64 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) )
            // InternalRos1Parser.g:6797:2: ( () otherlv_1= Float64 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            {
            // InternalRos1Parser.g:6797:2: ( () otherlv_1= Float64 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            // InternalRos1Parser.g:6798:3: () otherlv_1= Float64 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket
            {
            // InternalRos1Parser.g:6798:3: ()
            // InternalRos1Parser.g:6799:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFloat64ArrayAccess().getFloat64ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Float64,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getFloat64ArrayAccess().getFloat64Keyword_1());
            		
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_66); 

            			newLeafNode(otherlv_2, grammarAccess.getFloat64ArrayAccess().getLeftSquareBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,RightSquareBracket,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getFloat64ArrayAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

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
    // InternalRos1Parser.g:6821:1: entryRulestring0Array returns [EObject current=null] : iv_rulestring0Array= rulestring0Array EOF ;
    public final EObject entryRulestring0Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulestring0Array = null;


        try {
            // InternalRos1Parser.g:6821:53: (iv_rulestring0Array= rulestring0Array EOF )
            // InternalRos1Parser.g:6822:2: iv_rulestring0Array= rulestring0Array EOF
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
    // InternalRos1Parser.g:6828:1: rulestring0Array returns [EObject current=null] : ( () otherlv_1= String_1 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) ;
    public final EObject rulestring0Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6834:2: ( ( () otherlv_1= String_1 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) )
            // InternalRos1Parser.g:6835:2: ( () otherlv_1= String_1 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            {
            // InternalRos1Parser.g:6835:2: ( () otherlv_1= String_1 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            // InternalRos1Parser.g:6836:3: () otherlv_1= String_1 otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket
            {
            // InternalRos1Parser.g:6836:3: ()
            // InternalRos1Parser.g:6837:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getString0ArrayAccess().getStringArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,String_1,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getString0ArrayAccess().getStringKeyword_1());
            		
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_66); 

            			newLeafNode(otherlv_2, grammarAccess.getString0ArrayAccess().getLeftSquareBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,RightSquareBracket,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getString0ArrayAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

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
    // InternalRos1Parser.g:6859:1: entryRulebyteArray returns [EObject current=null] : iv_rulebyteArray= rulebyteArray EOF ;
    public final EObject entryRulebyteArray() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebyteArray = null;


        try {
            // InternalRos1Parser.g:6859:50: (iv_rulebyteArray= rulebyteArray EOF )
            // InternalRos1Parser.g:6860:2: iv_rulebyteArray= rulebyteArray EOF
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
    // InternalRos1Parser.g:6866:1: rulebyteArray returns [EObject current=null] : ( () otherlv_1= Byte otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) ;
    public final EObject rulebyteArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6872:2: ( ( () otherlv_1= Byte otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) )
            // InternalRos1Parser.g:6873:2: ( () otherlv_1= Byte otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            {
            // InternalRos1Parser.g:6873:2: ( () otherlv_1= Byte otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            // InternalRos1Parser.g:6874:3: () otherlv_1= Byte otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket
            {
            // InternalRos1Parser.g:6874:3: ()
            // InternalRos1Parser.g:6875:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getByteArrayAccess().getByteArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Byte,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getByteArrayAccess().getByteKeyword_1());
            		
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_66); 

            			newLeafNode(otherlv_2, grammarAccess.getByteArrayAccess().getLeftSquareBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,RightSquareBracket,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getByteArrayAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

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
    // InternalRos1Parser.g:6897:1: entryRulecharArray returns [EObject current=null] : iv_rulecharArray= rulecharArray EOF ;
    public final EObject entryRulecharArray() throws RecognitionException {
        EObject current = null;

        EObject iv_rulecharArray = null;


        try {
            // InternalRos1Parser.g:6897:50: (iv_rulecharArray= rulecharArray EOF )
            // InternalRos1Parser.g:6898:2: iv_rulecharArray= rulecharArray EOF
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
    // InternalRos1Parser.g:6904:1: rulecharArray returns [EObject current=null] : ( () otherlv_1= Char otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) ;
    public final EObject rulecharArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6910:2: ( ( () otherlv_1= Char otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket ) )
            // InternalRos1Parser.g:6911:2: ( () otherlv_1= Char otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            {
            // InternalRos1Parser.g:6911:2: ( () otherlv_1= Char otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket )
            // InternalRos1Parser.g:6912:3: () otherlv_1= Char otherlv_2= LeftSquareBracket otherlv_3= RightSquareBracket
            {
            // InternalRos1Parser.g:6912:3: ()
            // InternalRos1Parser.g:6913:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCharArrayAccess().getCharArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Char,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getCharArrayAccess().getCharKeyword_1());
            		
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_66); 

            			newLeafNode(otherlv_2, grammarAccess.getCharArrayAccess().getLeftSquareBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,RightSquareBracket,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getCharArrayAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

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
    // InternalRos1Parser.g:6935:1: entryRuleHeader returns [EObject current=null] : iv_ruleHeader= ruleHeader EOF ;
    public final EObject entryRuleHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHeader = null;


        try {
            // InternalRos1Parser.g:6935:47: (iv_ruleHeader= ruleHeader EOF )
            // InternalRos1Parser.g:6936:2: iv_ruleHeader= ruleHeader EOF
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
    // InternalRos1Parser.g:6942:1: ruleHeader returns [EObject current=null] : ( () otherlv_1= Header ) ;
    public final EObject ruleHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6948:2: ( ( () otherlv_1= Header ) )
            // InternalRos1Parser.g:6949:2: ( () otherlv_1= Header )
            {
            // InternalRos1Parser.g:6949:2: ( () otherlv_1= Header )
            // InternalRos1Parser.g:6950:3: () otherlv_1= Header
            {
            // InternalRos1Parser.g:6950:3: ()
            // InternalRos1Parser.g:6951:4: 
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
    // InternalRos1Parser.g:6965:1: entryRuleSpecBaseRef returns [EObject current=null] : iv_ruleSpecBaseRef= ruleSpecBaseRef EOF ;
    public final EObject entryRuleSpecBaseRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecBaseRef = null;


        try {
            // InternalRos1Parser.g:6965:52: (iv_ruleSpecBaseRef= ruleSpecBaseRef EOF )
            // InternalRos1Parser.g:6966:2: iv_ruleSpecBaseRef= ruleSpecBaseRef EOF
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
    // InternalRos1Parser.g:6972:1: ruleSpecBaseRef returns [EObject current=null] : ( ( ruleEString ) ) ;
    public final EObject ruleSpecBaseRef() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6978:2: ( ( ( ruleEString ) ) )
            // InternalRos1Parser.g:6979:2: ( ( ruleEString ) )
            {
            // InternalRos1Parser.g:6979:2: ( ( ruleEString ) )
            // InternalRos1Parser.g:6980:3: ( ruleEString )
            {
            // InternalRos1Parser.g:6980:3: ( ruleEString )
            // InternalRos1Parser.g:6981:4: ruleEString
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
    // InternalRos1Parser.g:6998:1: entryRuleArraySpecRef returns [EObject current=null] : iv_ruleArraySpecRef= ruleArraySpecRef EOF ;
    public final EObject entryRuleArraySpecRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArraySpecRef = null;


        try {
            // InternalRos1Parser.g:6998:53: (iv_ruleArraySpecRef= ruleArraySpecRef EOF )
            // InternalRos1Parser.g:6999:2: iv_ruleArraySpecRef= ruleArraySpecRef EOF
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
    // InternalRos1Parser.g:7005:1: ruleArraySpecRef returns [EObject current=null] : ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracket otherlv_2= RightSquareBracket ) ;
    public final EObject ruleArraySpecRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:7011:2: ( ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracket otherlv_2= RightSquareBracket ) )
            // InternalRos1Parser.g:7012:2: ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracket otherlv_2= RightSquareBracket )
            {
            // InternalRos1Parser.g:7012:2: ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracket otherlv_2= RightSquareBracket )
            // InternalRos1Parser.g:7013:3: ( ( ruleEString ) ) otherlv_1= LeftSquareBracket otherlv_2= RightSquareBracket
            {
            // InternalRos1Parser.g:7013:3: ( ( ruleEString ) )
            // InternalRos1Parser.g:7014:4: ( ruleEString )
            {
            // InternalRos1Parser.g:7014:4: ( ruleEString )
            // InternalRos1Parser.g:7015:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getArraySpecRefRule());
            					}
            				

            					newCompositeNode(grammarAccess.getArraySpecRefAccess().getReferenceTopicSpecCrossReference_0_0());
            				
            pushFollow(FOLLOW_10);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_66); 

            			newLeafNode(otherlv_1, grammarAccess.getArraySpecRefAccess().getLeftSquareBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,RightSquareBracket,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getArraySpecRefAccess().getRightSquareBracketKeyword_2());
            		

            }


            }


            	leaveRule();

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
    // InternalRos1Parser.g:7041:1: entryRuleKEYWORD returns [String current=null] : iv_ruleKEYWORD= ruleKEYWORD EOF ;
    public final String entryRuleKEYWORD() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKEYWORD = null;


        try {
            // InternalRos1Parser.g:7041:47: (iv_ruleKEYWORD= ruleKEYWORD EOF )
            // InternalRos1Parser.g:7042:2: iv_ruleKEYWORD= ruleKEYWORD EOF
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
    // InternalRos1Parser.g:7048:1: ruleKEYWORD returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time ) ;
    public final AntlrDatatypeRuleToken ruleKEYWORD() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:7054:2: ( (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time ) )
            // InternalRos1Parser.g:7055:2: (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time )
            {
            // InternalRos1Parser.g:7055:2: (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time )
            int alt102=11;
            switch ( input.LA(1) ) {
            case Goal:
                {
                alt102=1;
                }
                break;
            case Message:
                {
                alt102=2;
                }
                break;
            case Result:
                {
                alt102=3;
                }
                break;
            case Feedback:
                {
                alt102=4;
                }
                break;
            case Name:
                {
                alt102=5;
                }
                break;
            case Value:
                {
                alt102=6;
                }
                break;
            case Service:
                {
                alt102=7;
                }
                break;
            case Type:
                {
                alt102=8;
                }
                break;
            case Action:
                {
                alt102=9;
                }
                break;
            case Duration:
                {
                alt102=10;
                }
                break;
            case Time:
                {
                alt102=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }

            switch (alt102) {
                case 1 :
                    // InternalRos1Parser.g:7056:3: kw= Goal
                    {
                    kw=(Token)match(input,Goal,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getGoalKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:7062:3: kw= Message
                    {
                    kw=(Token)match(input,Message,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getMessageKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRos1Parser.g:7068:3: kw= Result
                    {
                    kw=(Token)match(input,Result,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getResultKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRos1Parser.g:7074:3: kw= Feedback
                    {
                    kw=(Token)match(input,Feedback,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getFeedbackKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRos1Parser.g:7080:3: kw= Name
                    {
                    kw=(Token)match(input,Name,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getNameKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalRos1Parser.g:7086:3: kw= Value
                    {
                    kw=(Token)match(input,Value,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getValueKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalRos1Parser.g:7092:3: kw= Service
                    {
                    kw=(Token)match(input,Service,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getServiceKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalRos1Parser.g:7098:3: kw= Type
                    {
                    kw=(Token)match(input,Type,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getTypeKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalRos1Parser.g:7104:3: kw= Action
                    {
                    kw=(Token)match(input,Action,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getActionKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalRos1Parser.g:7110:3: kw= Duration
                    {
                    kw=(Token)match(input,Duration,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getDurationKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalRos1Parser.g:7116:3: kw= Time
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
    // InternalRos1Parser.g:7125:1: entryRuleQualifiedRef returns [String current=null] : iv_ruleQualifiedRef= ruleQualifiedRef EOF ;
    public final String entryRuleQualifiedRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedRef = null;


        try {
            // InternalRos1Parser.g:7125:52: (iv_ruleQualifiedRef= ruleQualifiedRef EOF )
            // InternalRos1Parser.g:7126:2: iv_ruleQualifiedRef= ruleQualifiedRef EOF
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
    // InternalRos1Parser.g:7132:1: ruleQualifiedRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | (this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )* ) ) ;
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
            // InternalRos1Parser.g:7138:2: ( (this_STRING_0= RULE_STRING | (this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )* ) ) )
            // InternalRos1Parser.g:7139:2: (this_STRING_0= RULE_STRING | (this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )* ) )
            {
            // InternalRos1Parser.g:7139:2: (this_STRING_0= RULE_STRING | (this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )* ) )
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==RULE_STRING) ) {
                alt105=1;
            }
            else if ( (LA105_0==RULE_ID) ) {
                alt105=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;
            }
            switch (alt105) {
                case 1 :
                    // InternalRos1Parser.g:7140:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getQualifiedRefAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:7148:3: (this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )* )
                    {
                    // InternalRos1Parser.g:7148:3: (this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )* )
                    // InternalRos1Parser.g:7149:4: this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )*
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_71); 

                    				current.merge(this_ID_1);
                    			

                    				newLeafNode(this_ID_1, grammarAccess.getQualifiedRefAccess().getIDTerminalRuleCall_1_0());
                    			
                    // InternalRos1Parser.g:7156:4: ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )*
                    loop104:
                    do {
                        int alt104=3;
                        int LA104_0 = input.LA(1);

                        if ( (LA104_0==FullStop) ) {
                            alt104=1;
                        }
                        else if ( (LA104_0==RULE_DOUBLE) ) {
                            alt104=2;
                        }


                        switch (alt104) {
                    	case 1 :
                    	    // InternalRos1Parser.g:7157:5: (kw= FullStop this_ID_3= RULE_ID )
                    	    {
                    	    // InternalRos1Parser.g:7157:5: (kw= FullStop this_ID_3= RULE_ID )
                    	    // InternalRos1Parser.g:7158:6: kw= FullStop this_ID_3= RULE_ID
                    	    {
                    	    kw=(Token)match(input,FullStop,FOLLOW_72); 

                    	    						current.merge(kw);
                    	    						newLeafNode(kw, grammarAccess.getQualifiedRefAccess().getFullStopKeyword_1_1_0_0());
                    	    					
                    	    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_71); 

                    	    						current.merge(this_ID_3);
                    	    					

                    	    						newLeafNode(this_ID_3, grammarAccess.getQualifiedRefAccess().getIDTerminalRuleCall_1_1_0_1());
                    	    					

                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalRos1Parser.g:7172:5: (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? )
                    	    {
                    	    // InternalRos1Parser.g:7172:5: (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? )
                    	    // InternalRos1Parser.g:7173:6: this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )?
                    	    {
                    	    this_DOUBLE_4=(Token)match(input,RULE_DOUBLE,FOLLOW_73); 

                    	    						current.merge(this_DOUBLE_4);
                    	    					

                    	    						newLeafNode(this_DOUBLE_4, grammarAccess.getQualifiedRefAccess().getDOUBLETerminalRuleCall_1_1_1_0());
                    	    					
                    	    // InternalRos1Parser.g:7180:6: (this_ID_5= RULE_ID )?
                    	    int alt103=2;
                    	    int LA103_0 = input.LA(1);

                    	    if ( (LA103_0==RULE_ID) ) {
                    	        alt103=1;
                    	    }
                    	    switch (alt103) {
                    	        case 1 :
                    	            // InternalRos1Parser.g:7181:7: this_ID_5= RULE_ID
                    	            {
                    	            this_ID_5=(Token)match(input,RULE_ID,FOLLOW_71); 

                    	            							current.merge(this_ID_5);
                    	            						

                    	            							newLeafNode(this_ID_5, grammarAccess.getQualifiedRefAccess().getIDTerminalRuleCall_1_1_1_1());
                    	            						

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop104;
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
    // InternalRos1Parser.g:7196:1: entryRuleExtensionBlock returns [EObject current=null] : iv_ruleExtensionBlock= ruleExtensionBlock EOF ;
    public final EObject entryRuleExtensionBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionBlock = null;


        try {
            // InternalRos1Parser.g:7196:55: (iv_ruleExtensionBlock= ruleExtensionBlock EOF )
            // InternalRos1Parser.g:7197:2: iv_ruleExtensionBlock= ruleExtensionBlock EOF
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
    // InternalRos1Parser.g:7203:1: ruleExtensionBlock returns [EObject current=null] : ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? ) ;
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
            // InternalRos1Parser.g:7209:2: ( ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? ) )
            // InternalRos1Parser.g:7210:2: ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? )
            {
            // InternalRos1Parser.g:7210:2: ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? )
            // InternalRos1Parser.g:7211:3: () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )?
            {
            // InternalRos1Parser.g:7211:3: ()
            // InternalRos1Parser.g:7212:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionBlockAccess().getExtensionBlockAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,CommercialAt,FOLLOW_72); 

            			newLeafNode(otherlv_1, grammarAccess.getExtensionBlockAccess().getCommercialAtKeyword_1());
            		
            // InternalRos1Parser.g:7222:3: ( (lv_name_2_0= ruleExtensionBlockName ) )
            // InternalRos1Parser.g:7223:4: (lv_name_2_0= ruleExtensionBlockName )
            {
            // InternalRos1Parser.g:7223:4: (lv_name_2_0= ruleExtensionBlockName )
            // InternalRos1Parser.g:7224:5: lv_name_2_0= ruleExtensionBlockName
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

            otherlv_3=(Token)match(input,Colon,FOLLOW_74); 

            			newLeafNode(otherlv_3, grammarAccess.getExtensionBlockAccess().getColonKeyword_3());
            		
            // InternalRos1Parser.g:7245:3: ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )?
            int alt110=3;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==RULE_BEGIN) ) {
                alt110=1;
            }
            else if ( (LA110_0==LeftCurlyBracket) ) {
                alt110=2;
            }
            switch (alt110) {
                case 1 :
                    // InternalRos1Parser.g:7246:4: (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END )
                    {
                    // InternalRos1Parser.g:7246:4: (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END )
                    // InternalRos1Parser.g:7247:5: this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END
                    {
                    this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_75); 

                    					newLeafNode(this_BEGIN_4, grammarAccess.getExtensionBlockAccess().getBEGINTerminalRuleCall_4_0_0());
                    				
                    // InternalRos1Parser.g:7251:5: ( (lv_entries_5_0= ruleExtensionEntry ) )+
                    int cnt106=0;
                    loop106:
                    do {
                        int alt106=2;
                        int LA106_0 = input.LA(1);

                        if ( ((LA106_0>=Serviceclients && LA106_0<=Dependencies)||(LA106_0>=FromGitRepo && LA106_0<=Publishers)||LA106_0==Parameter||(LA106_0>=Multiple && LA106_0<=Plugins)||(LA106_0>=Boolean && LA106_0<=Message)||(LA106_0>=Service && LA106_0<=Node_1)||LA106_0==Srvs||(LA106_0>=Type_1 && LA106_0<=List)||(LA106_0>=Bool && LA106_0<=Node)||(LA106_0>=Time && LA106_0<=Ns)||(LA106_0>=RULE_ID && LA106_0<=RULE_STRING)) ) {
                            alt106=1;
                        }


                        switch (alt106) {
                    	case 1 :
                    	    // InternalRos1Parser.g:7252:6: (lv_entries_5_0= ruleExtensionEntry )
                    	    {
                    	    // InternalRos1Parser.g:7252:6: (lv_entries_5_0= ruleExtensionEntry )
                    	    // InternalRos1Parser.g:7253:7: lv_entries_5_0= ruleExtensionEntry
                    	    {

                    	    							newCompositeNode(grammarAccess.getExtensionBlockAccess().getEntriesExtensionEntryParserRuleCall_4_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_76);
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
                    	    if ( cnt106 >= 1 ) break loop106;
                                EarlyExitException eee =
                                    new EarlyExitException(106, input);
                                throw eee;
                        }
                        cnt106++;
                    } while (true);

                    this_END_6=(Token)match(input,RULE_END,FOLLOW_2); 

                    					newLeafNode(this_END_6, grammarAccess.getExtensionBlockAccess().getENDTerminalRuleCall_4_0_2());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:7276:4: (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket )
                    {
                    // InternalRos1Parser.g:7276:4: (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket )
                    // InternalRos1Parser.g:7277:5: otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket
                    {
                    otherlv_7=(Token)match(input,LeftCurlyBracket,FOLLOW_77); 

                    					newLeafNode(otherlv_7, grammarAccess.getExtensionBlockAccess().getLeftCurlyBracketKeyword_4_1_0());
                    				
                    // InternalRos1Parser.g:7281:5: ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )?
                    int alt109=2;
                    int LA109_0 = input.LA(1);

                    if ( ((LA109_0>=Serviceclients && LA109_0<=Dependencies)||(LA109_0>=FromGitRepo && LA109_0<=Publishers)||LA109_0==Parameter||(LA109_0>=Multiple && LA109_0<=Plugins)||(LA109_0>=Boolean && LA109_0<=Message)||(LA109_0>=Service && LA109_0<=Node_1)||LA109_0==Srvs||(LA109_0>=Type_1 && LA109_0<=List)||(LA109_0>=Bool && LA109_0<=Node)||(LA109_0>=Time && LA109_0<=Ns)||(LA109_0>=RULE_ID && LA109_0<=RULE_STRING)) ) {
                        alt109=1;
                    }
                    switch (alt109) {
                        case 1 :
                            // InternalRos1Parser.g:7282:6: ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )*
                            {
                            // InternalRos1Parser.g:7282:6: ( (lv_entries_8_0= ruleExtensionEntry ) )
                            // InternalRos1Parser.g:7283:7: (lv_entries_8_0= ruleExtensionEntry )
                            {
                            // InternalRos1Parser.g:7283:7: (lv_entries_8_0= ruleExtensionEntry )
                            // InternalRos1Parser.g:7284:8: lv_entries_8_0= ruleExtensionEntry
                            {

                            								newCompositeNode(grammarAccess.getExtensionBlockAccess().getEntriesExtensionEntryParserRuleCall_4_1_1_0_0());
                            							
                            pushFollow(FOLLOW_78);
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

                            // InternalRos1Parser.g:7301:6: ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )*
                            loop108:
                            do {
                                int alt108=2;
                                int LA108_0 = input.LA(1);

                                if ( ((LA108_0>=Serviceclients && LA108_0<=Dependencies)||(LA108_0>=FromGitRepo && LA108_0<=Publishers)||LA108_0==Parameter||(LA108_0>=Multiple && LA108_0<=Plugins)||(LA108_0>=Boolean && LA108_0<=Message)||(LA108_0>=Service && LA108_0<=Node_1)||LA108_0==Srvs||(LA108_0>=Type_1 && LA108_0<=List)||(LA108_0>=Bool && LA108_0<=Node)||(LA108_0>=Time && LA108_0<=Ns)||LA108_0==Comma||(LA108_0>=RULE_ID && LA108_0<=RULE_STRING)) ) {
                                    alt108=1;
                                }


                                switch (alt108) {
                            	case 1 :
                            	    // InternalRos1Parser.g:7302:7: (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) )
                            	    {
                            	    // InternalRos1Parser.g:7302:7: (otherlv_9= Comma )?
                            	    int alt107=2;
                            	    int LA107_0 = input.LA(1);

                            	    if ( (LA107_0==Comma) ) {
                            	        alt107=1;
                            	    }
                            	    switch (alt107) {
                            	        case 1 :
                            	            // InternalRos1Parser.g:7303:8: otherlv_9= Comma
                            	            {
                            	            otherlv_9=(Token)match(input,Comma,FOLLOW_75); 

                            	            								newLeafNode(otherlv_9, grammarAccess.getExtensionBlockAccess().getCommaKeyword_4_1_1_1_0());
                            	            							

                            	            }
                            	            break;

                            	    }

                            	    // InternalRos1Parser.g:7308:7: ( (lv_entries_10_0= ruleExtensionEntry ) )
                            	    // InternalRos1Parser.g:7309:8: (lv_entries_10_0= ruleExtensionEntry )
                            	    {
                            	    // InternalRos1Parser.g:7309:8: (lv_entries_10_0= ruleExtensionEntry )
                            	    // InternalRos1Parser.g:7310:9: lv_entries_10_0= ruleExtensionEntry
                            	    {

                            	    									newCompositeNode(grammarAccess.getExtensionBlockAccess().getEntriesExtensionEntryParserRuleCall_4_1_1_1_1_0());
                            	    								
                            	    pushFollow(FOLLOW_78);
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
                            	    break loop108;
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
    // InternalRos1Parser.g:7339:1: entryRuleExtensionBlockName returns [String current=null] : iv_ruleExtensionBlockName= ruleExtensionBlockName EOF ;
    public final String entryRuleExtensionBlockName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionBlockName = null;


        try {
            // InternalRos1Parser.g:7339:58: (iv_ruleExtensionBlockName= ruleExtensionBlockName EOF )
            // InternalRos1Parser.g:7340:2: iv_ruleExtensionBlockName= ruleExtensionBlockName EOF
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
    // InternalRos1Parser.g:7346:1: ruleExtensionBlockName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleExtensionBlockName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:7352:2: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // InternalRos1Parser.g:7353:2: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // InternalRos1Parser.g:7353:2: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // InternalRos1Parser.g:7354:3: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_79); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getExtensionBlockNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalRos1Parser.g:7361:3: (kw= FullStop this_ID_2= RULE_ID )*
            loop111:
            do {
                int alt111=2;
                int LA111_0 = input.LA(1);

                if ( (LA111_0==FullStop) ) {
                    alt111=1;
                }


                switch (alt111) {
            	case 1 :
            	    // InternalRos1Parser.g:7362:4: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_72); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getExtensionBlockNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_79); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getExtensionBlockNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop111;
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
    // InternalRos1Parser.g:7379:1: entryRuleExtensionEntry returns [EObject current=null] : iv_ruleExtensionEntry= ruleExtensionEntry EOF ;
    public final EObject entryRuleExtensionEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionEntry = null;


        try {
            // InternalRos1Parser.g:7379:55: (iv_ruleExtensionEntry= ruleExtensionEntry EOF )
            // InternalRos1Parser.g:7380:2: iv_ruleExtensionEntry= ruleExtensionEntry EOF
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
    // InternalRos1Parser.g:7386:1: ruleExtensionEntry returns [EObject current=null] : ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) | ( (lv_key_4_0= ruleAddedKeywordName ) ) ) ( (lv_value_5_0= ruleExtensionValue ) ) ) ;
    public final EObject ruleExtensionEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_key_1_0 = null;

        AntlrDatatypeRuleToken lv_key_3_0 = null;

        AntlrDatatypeRuleToken lv_key_4_0 = null;

        EObject lv_value_5_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:7392:2: ( ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) | ( (lv_key_4_0= ruleAddedKeywordName ) ) ) ( (lv_value_5_0= ruleExtensionValue ) ) ) )
            // InternalRos1Parser.g:7393:2: ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) | ( (lv_key_4_0= ruleAddedKeywordName ) ) ) ( (lv_value_5_0= ruleExtensionValue ) ) )
            {
            // InternalRos1Parser.g:7393:2: ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) | ( (lv_key_4_0= ruleAddedKeywordName ) ) ) ( (lv_value_5_0= ruleExtensionValue ) ) )
            // InternalRos1Parser.g:7394:3: () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) | ( (lv_key_4_0= ruleAddedKeywordName ) ) ) ( (lv_value_5_0= ruleExtensionValue ) )
            {
            // InternalRos1Parser.g:7394:3: ()
            // InternalRos1Parser.g:7395:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionEntryAccess().getExtensionEntryAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:7401:3: ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) | ( (lv_key_4_0= ruleAddedKeywordName ) ) )
            int alt112=3;
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
                alt112=1;
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
                alt112=2;
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
                alt112=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;
            }

            switch (alt112) {
                case 1 :
                    // InternalRos1Parser.g:7402:4: ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon )
                    {
                    // InternalRos1Parser.g:7402:4: ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon )
                    // InternalRos1Parser.g:7403:5: ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon
                    {
                    // InternalRos1Parser.g:7403:5: ( (lv_key_1_0= ruleExtensionKey ) )
                    // InternalRos1Parser.g:7404:6: (lv_key_1_0= ruleExtensionKey )
                    {
                    // InternalRos1Parser.g:7404:6: (lv_key_1_0= ruleExtensionKey )
                    // InternalRos1Parser.g:7405:7: lv_key_1_0= ruleExtensionKey
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

                    otherlv_2=(Token)match(input,Colon,FOLLOW_80); 

                    					newLeafNode(otherlv_2, grammarAccess.getExtensionEntryAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:7428:4: ( (lv_key_3_0= ruleExtensionColonKey ) )
                    {
                    // InternalRos1Parser.g:7428:4: ( (lv_key_3_0= ruleExtensionColonKey ) )
                    // InternalRos1Parser.g:7429:5: (lv_key_3_0= ruleExtensionColonKey )
                    {
                    // InternalRos1Parser.g:7429:5: (lv_key_3_0= ruleExtensionColonKey )
                    // InternalRos1Parser.g:7430:6: lv_key_3_0= ruleExtensionColonKey
                    {

                    						newCompositeNode(grammarAccess.getExtensionEntryAccess().getKeyExtensionColonKeyParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_80);
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
                    // InternalRos1Parser.g:7448:4: ( (lv_key_4_0= ruleAddedKeywordName ) )
                    {
                    // InternalRos1Parser.g:7448:4: ( (lv_key_4_0= ruleAddedKeywordName ) )
                    // InternalRos1Parser.g:7449:5: (lv_key_4_0= ruleAddedKeywordName )
                    {
                    // InternalRos1Parser.g:7449:5: (lv_key_4_0= ruleAddedKeywordName )
                    // InternalRos1Parser.g:7450:6: lv_key_4_0= ruleAddedKeywordName
                    {

                    						newCompositeNode(grammarAccess.getExtensionEntryAccess().getKeyAddedKeywordNameParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_80);
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

            // InternalRos1Parser.g:7468:3: ( (lv_value_5_0= ruleExtensionValue ) )
            // InternalRos1Parser.g:7469:4: (lv_value_5_0= ruleExtensionValue )
            {
            // InternalRos1Parser.g:7469:4: (lv_value_5_0= ruleExtensionValue )
            // InternalRos1Parser.g:7470:5: lv_value_5_0= ruleExtensionValue
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
    // InternalRos1Parser.g:7491:1: entryRuleExtensionValue returns [EObject current=null] : iv_ruleExtensionValue= ruleExtensionValue EOF ;
    public final EObject entryRuleExtensionValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionValue = null;


        try {
            // InternalRos1Parser.g:7491:55: (iv_ruleExtensionValue= ruleExtensionValue EOF )
            // InternalRos1Parser.g:7492:2: iv_ruleExtensionValue= ruleExtensionValue EOF
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
    // InternalRos1Parser.g:7498:1: ruleExtensionValue returns [EObject current=null] : (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue ) ;
    public final EObject ruleExtensionValue() throws RecognitionException {
        EObject current = null;

        EObject this_ExtensionListValue_0 = null;

        EObject this_ExtensionBraceMapValue_1 = null;

        EObject this_ExtensionIndentedMapValue_2 = null;

        EObject this_ExtensionRefValue_3 = null;

        EObject this_ExtensionScalarValue_4 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:7504:2: ( (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue ) )
            // InternalRos1Parser.g:7505:2: (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue )
            {
            // InternalRos1Parser.g:7505:2: (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue )
            int alt113=5;
            switch ( input.LA(1) ) {
            case LeftSquareBracket:
                {
                alt113=1;
                }
                break;
            case LeftCurlyBracket:
                {
                alt113=2;
                }
                break;
            case RULE_BEGIN:
                {
                alt113=3;
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
                alt113=4;
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
                alt113=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 113, 0, input);

                throw nvae;
            }

            switch (alt113) {
                case 1 :
                    // InternalRos1Parser.g:7506:3: this_ExtensionListValue_0= ruleExtensionListValue
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
                    // InternalRos1Parser.g:7515:3: this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue
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
                    // InternalRos1Parser.g:7524:3: this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue
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
                    // InternalRos1Parser.g:7533:3: this_ExtensionRefValue_3= ruleExtensionRefValue
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
                    // InternalRos1Parser.g:7542:3: this_ExtensionScalarValue_4= ruleExtensionScalarValue
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
    // InternalRos1Parser.g:7554:1: entryRuleExtensionListValue returns [EObject current=null] : iv_ruleExtensionListValue= ruleExtensionListValue EOF ;
    public final EObject entryRuleExtensionListValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionListValue = null;


        try {
            // InternalRos1Parser.g:7554:59: (iv_ruleExtensionListValue= ruleExtensionListValue EOF )
            // InternalRos1Parser.g:7555:2: iv_ruleExtensionListValue= ruleExtensionListValue EOF
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
    // InternalRos1Parser.g:7561:1: ruleExtensionListValue returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket ) ;
    public final EObject ruleExtensionListValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_items_2_0 = null;

        EObject lv_items_4_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:7567:2: ( ( () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket ) )
            // InternalRos1Parser.g:7568:2: ( () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket )
            {
            // InternalRos1Parser.g:7568:2: ( () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket )
            // InternalRos1Parser.g:7569:3: () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket
            {
            // InternalRos1Parser.g:7569:3: ()
            // InternalRos1Parser.g:7570:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionListValueAccess().getExtensionListValueAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_81); 

            			newLeafNode(otherlv_1, grammarAccess.getExtensionListValueAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalRos1Parser.g:7580:3: ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )?
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( ((LA116_0>=Duration && LA116_0<=Feedback)||(LA116_0>=Boolean && LA116_0<=Float64)||(LA116_0>=Library && LA116_0<=Param)||(LA116_0>=Service && LA116_0<=Uint64)||LA116_0==Array||(LA116_0>=Class && LA116_0<=Int64)||LA116_0==Pub||LA116_0==Sub||(LA116_0>=Uint8 && LA116_0<=Any)||LA116_0==LeftSquareBracket||LA116_0==LeftCurlyBracket||(LA116_0>=RULE_BOOLEAN && LA116_0<=RULE_DOUBLE)||(LA116_0>=RULE_ID && LA116_0<=RULE_INT)||LA116_0==RULE_BEGIN) ) {
                alt116=1;
            }
            switch (alt116) {
                case 1 :
                    // InternalRos1Parser.g:7581:4: ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )*
                    {
                    // InternalRos1Parser.g:7581:4: ( (lv_items_2_0= ruleExtensionValue ) )
                    // InternalRos1Parser.g:7582:5: (lv_items_2_0= ruleExtensionValue )
                    {
                    // InternalRos1Parser.g:7582:5: (lv_items_2_0= ruleExtensionValue )
                    // InternalRos1Parser.g:7583:6: lv_items_2_0= ruleExtensionValue
                    {

                    						newCompositeNode(grammarAccess.getExtensionListValueAccess().getItemsExtensionValueParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_82);
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

                    // InternalRos1Parser.g:7600:4: ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )*
                    loop115:
                    do {
                        int alt115=2;
                        int LA115_0 = input.LA(1);

                        if ( ((LA115_0>=Duration && LA115_0<=Feedback)||(LA115_0>=Boolean && LA115_0<=Float64)||(LA115_0>=Library && LA115_0<=Param)||(LA115_0>=Service && LA115_0<=Uint64)||LA115_0==Array||(LA115_0>=Class && LA115_0<=Int64)||LA115_0==Pub||LA115_0==Sub||(LA115_0>=Uint8 && LA115_0<=Any)||LA115_0==Comma||LA115_0==LeftSquareBracket||LA115_0==LeftCurlyBracket||(LA115_0>=RULE_BOOLEAN && LA115_0<=RULE_DOUBLE)||(LA115_0>=RULE_ID && LA115_0<=RULE_INT)||LA115_0==RULE_BEGIN) ) {
                            alt115=1;
                        }


                        switch (alt115) {
                    	case 1 :
                    	    // InternalRos1Parser.g:7601:5: (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) )
                    	    {
                    	    // InternalRos1Parser.g:7601:5: (otherlv_3= Comma )?
                    	    int alt114=2;
                    	    int LA114_0 = input.LA(1);

                    	    if ( (LA114_0==Comma) ) {
                    	        alt114=1;
                    	    }
                    	    switch (alt114) {
                    	        case 1 :
                    	            // InternalRos1Parser.g:7602:6: otherlv_3= Comma
                    	            {
                    	            otherlv_3=(Token)match(input,Comma,FOLLOW_80); 

                    	            						newLeafNode(otherlv_3, grammarAccess.getExtensionListValueAccess().getCommaKeyword_2_1_0());
                    	            					

                    	            }
                    	            break;

                    	    }

                    	    // InternalRos1Parser.g:7607:5: ( (lv_items_4_0= ruleExtensionValue ) )
                    	    // InternalRos1Parser.g:7608:6: (lv_items_4_0= ruleExtensionValue )
                    	    {
                    	    // InternalRos1Parser.g:7608:6: (lv_items_4_0= ruleExtensionValue )
                    	    // InternalRos1Parser.g:7609:7: lv_items_4_0= ruleExtensionValue
                    	    {

                    	    							newCompositeNode(grammarAccess.getExtensionListValueAccess().getItemsExtensionValueParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_82);
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
                    	    break loop115;
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
    // InternalRos1Parser.g:7636:1: entryRuleExtensionBraceMapValue returns [EObject current=null] : iv_ruleExtensionBraceMapValue= ruleExtensionBraceMapValue EOF ;
    public final EObject entryRuleExtensionBraceMapValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionBraceMapValue = null;


        try {
            // InternalRos1Parser.g:7636:63: (iv_ruleExtensionBraceMapValue= ruleExtensionBraceMapValue EOF )
            // InternalRos1Parser.g:7637:2: iv_ruleExtensionBraceMapValue= ruleExtensionBraceMapValue EOF
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
    // InternalRos1Parser.g:7643:1: ruleExtensionBraceMapValue returns [EObject current=null] : ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket ) ;
    public final EObject ruleExtensionBraceMapValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_entries_2_0 = null;

        EObject lv_entries_4_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:7649:2: ( ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket ) )
            // InternalRos1Parser.g:7650:2: ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket )
            {
            // InternalRos1Parser.g:7650:2: ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket )
            // InternalRos1Parser.g:7651:3: () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket
            {
            // InternalRos1Parser.g:7651:3: ()
            // InternalRos1Parser.g:7652:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionBraceMapValueAccess().getExtensionMapValueAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LeftCurlyBracket,FOLLOW_77); 

            			newLeafNode(otherlv_1, grammarAccess.getExtensionBraceMapValueAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalRos1Parser.g:7662:3: ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( ((LA119_0>=Serviceclients && LA119_0<=Dependencies)||(LA119_0>=FromGitRepo && LA119_0<=Publishers)||LA119_0==Parameter||(LA119_0>=Multiple && LA119_0<=Plugins)||(LA119_0>=Boolean && LA119_0<=Message)||(LA119_0>=Service && LA119_0<=Node_1)||LA119_0==Srvs||(LA119_0>=Type_1 && LA119_0<=List)||(LA119_0>=Bool && LA119_0<=Node)||(LA119_0>=Time && LA119_0<=Ns)||(LA119_0>=RULE_ID && LA119_0<=RULE_STRING)) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // InternalRos1Parser.g:7663:4: ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )*
                    {
                    // InternalRos1Parser.g:7663:4: ( (lv_entries_2_0= ruleExtensionEntry ) )
                    // InternalRos1Parser.g:7664:5: (lv_entries_2_0= ruleExtensionEntry )
                    {
                    // InternalRos1Parser.g:7664:5: (lv_entries_2_0= ruleExtensionEntry )
                    // InternalRos1Parser.g:7665:6: lv_entries_2_0= ruleExtensionEntry
                    {

                    						newCompositeNode(grammarAccess.getExtensionBraceMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_78);
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

                    // InternalRos1Parser.g:7682:4: ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )*
                    loop118:
                    do {
                        int alt118=2;
                        int LA118_0 = input.LA(1);

                        if ( ((LA118_0>=Serviceclients && LA118_0<=Dependencies)||(LA118_0>=FromGitRepo && LA118_0<=Publishers)||LA118_0==Parameter||(LA118_0>=Multiple && LA118_0<=Plugins)||(LA118_0>=Boolean && LA118_0<=Message)||(LA118_0>=Service && LA118_0<=Node_1)||LA118_0==Srvs||(LA118_0>=Type_1 && LA118_0<=List)||(LA118_0>=Bool && LA118_0<=Node)||(LA118_0>=Time && LA118_0<=Ns)||LA118_0==Comma||(LA118_0>=RULE_ID && LA118_0<=RULE_STRING)) ) {
                            alt118=1;
                        }


                        switch (alt118) {
                    	case 1 :
                    	    // InternalRos1Parser.g:7683:5: (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) )
                    	    {
                    	    // InternalRos1Parser.g:7683:5: (otherlv_3= Comma )?
                    	    int alt117=2;
                    	    int LA117_0 = input.LA(1);

                    	    if ( (LA117_0==Comma) ) {
                    	        alt117=1;
                    	    }
                    	    switch (alt117) {
                    	        case 1 :
                    	            // InternalRos1Parser.g:7684:6: otherlv_3= Comma
                    	            {
                    	            otherlv_3=(Token)match(input,Comma,FOLLOW_75); 

                    	            						newLeafNode(otherlv_3, grammarAccess.getExtensionBraceMapValueAccess().getCommaKeyword_2_1_0());
                    	            					

                    	            }
                    	            break;

                    	    }

                    	    // InternalRos1Parser.g:7689:5: ( (lv_entries_4_0= ruleExtensionEntry ) )
                    	    // InternalRos1Parser.g:7690:6: (lv_entries_4_0= ruleExtensionEntry )
                    	    {
                    	    // InternalRos1Parser.g:7690:6: (lv_entries_4_0= ruleExtensionEntry )
                    	    // InternalRos1Parser.g:7691:7: lv_entries_4_0= ruleExtensionEntry
                    	    {

                    	    							newCompositeNode(grammarAccess.getExtensionBraceMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_78);
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
                    	    break loop118;
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
    // InternalRos1Parser.g:7718:1: entryRuleExtensionIndentedMapValue returns [EObject current=null] : iv_ruleExtensionIndentedMapValue= ruleExtensionIndentedMapValue EOF ;
    public final EObject entryRuleExtensionIndentedMapValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionIndentedMapValue = null;


        try {
            // InternalRos1Parser.g:7718:66: (iv_ruleExtensionIndentedMapValue= ruleExtensionIndentedMapValue EOF )
            // InternalRos1Parser.g:7719:2: iv_ruleExtensionIndentedMapValue= ruleExtensionIndentedMapValue EOF
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
    // InternalRos1Parser.g:7725:1: ruleExtensionIndentedMapValue returns [EObject current=null] : ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END ) ;
    public final EObject ruleExtensionIndentedMapValue() throws RecognitionException {
        EObject current = null;

        Token this_BEGIN_1=null;
        Token this_END_3=null;
        EObject lv_entries_2_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:7731:2: ( ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END ) )
            // InternalRos1Parser.g:7732:2: ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END )
            {
            // InternalRos1Parser.g:7732:2: ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END )
            // InternalRos1Parser.g:7733:3: () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END
            {
            // InternalRos1Parser.g:7733:3: ()
            // InternalRos1Parser.g:7734:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionIndentedMapValueAccess().getExtensionMapValueAction_0(),
            					current);
            			

            }

            this_BEGIN_1=(Token)match(input,RULE_BEGIN,FOLLOW_75); 

            			newLeafNode(this_BEGIN_1, grammarAccess.getExtensionIndentedMapValueAccess().getBEGINTerminalRuleCall_1());
            		
            // InternalRos1Parser.g:7744:3: ( (lv_entries_2_0= ruleExtensionEntry ) )+
            int cnt120=0;
            loop120:
            do {
                int alt120=2;
                int LA120_0 = input.LA(1);

                if ( ((LA120_0>=Serviceclients && LA120_0<=Dependencies)||(LA120_0>=FromGitRepo && LA120_0<=Publishers)||LA120_0==Parameter||(LA120_0>=Multiple && LA120_0<=Plugins)||(LA120_0>=Boolean && LA120_0<=Message)||(LA120_0>=Service && LA120_0<=Node_1)||LA120_0==Srvs||(LA120_0>=Type_1 && LA120_0<=List)||(LA120_0>=Bool && LA120_0<=Node)||(LA120_0>=Time && LA120_0<=Ns)||(LA120_0>=RULE_ID && LA120_0<=RULE_STRING)) ) {
                    alt120=1;
                }


                switch (alt120) {
            	case 1 :
            	    // InternalRos1Parser.g:7745:4: (lv_entries_2_0= ruleExtensionEntry )
            	    {
            	    // InternalRos1Parser.g:7745:4: (lv_entries_2_0= ruleExtensionEntry )
            	    // InternalRos1Parser.g:7746:5: lv_entries_2_0= ruleExtensionEntry
            	    {

            	    					newCompositeNode(grammarAccess.getExtensionIndentedMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_76);
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
            	    if ( cnt120 >= 1 ) break loop120;
                        EarlyExitException eee =
                            new EarlyExitException(120, input);
                        throw eee;
                }
                cnt120++;
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
    // InternalRos1Parser.g:7771:1: entryRuleExtensionRefValue returns [EObject current=null] : iv_ruleExtensionRefValue= ruleExtensionRefValue EOF ;
    public final EObject entryRuleExtensionRefValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionRefValue = null;


        try {
            // InternalRos1Parser.g:7771:58: (iv_ruleExtensionRefValue= ruleExtensionRefValue EOF )
            // InternalRos1Parser.g:7772:2: iv_ruleExtensionRefValue= ruleExtensionRefValue EOF
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
    // InternalRos1Parser.g:7778:1: ruleExtensionRefValue returns [EObject current=null] : ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) ) ;
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
            // InternalRos1Parser.g:7784:2: ( ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) ) )
            // InternalRos1Parser.g:7785:2: ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) )
            {
            // InternalRos1Parser.g:7785:2: ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) )
            // InternalRos1Parser.g:7786:3: () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) )
            {
            // InternalRos1Parser.g:7786:3: ()
            // InternalRos1Parser.g:7787:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionRefValueAccess().getExtensionRefValueAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:7793:3: ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) )
            // InternalRos1Parser.g:7794:4: ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) )
            {
            // InternalRos1Parser.g:7794:4: ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) )
            // InternalRos1Parser.g:7795:5: (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param )
            {
            // InternalRos1Parser.g:7795:5: (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param )
            int alt121=7;
            switch ( input.LA(1) ) {
            case Pub:
                {
                alt121=1;
                }
                break;
            case Sub:
                {
                alt121=2;
                }
                break;
            case Ss:
                {
                alt121=3;
                }
                break;
            case Sc:
                {
                alt121=4;
                }
                break;
            case As:
                {
                alt121=5;
                }
                break;
            case Ac:
                {
                alt121=6;
                }
                break;
            case Param:
                {
                alt121=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 121, 0, input);

                throw nvae;
            }

            switch (alt121) {
                case 1 :
                    // InternalRos1Parser.g:7796:6: lv_refKind_1_1= Pub
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
                    // InternalRos1Parser.g:7807:6: lv_refKind_1_2= Sub
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
                    // InternalRos1Parser.g:7818:6: lv_refKind_1_3= Ss
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
                    // InternalRos1Parser.g:7829:6: lv_refKind_1_4= Sc
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
                    // InternalRos1Parser.g:7840:6: lv_refKind_1_5= As
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
                    // InternalRos1Parser.g:7851:6: lv_refKind_1_6= Ac
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
                    // InternalRos1Parser.g:7862:6: lv_refKind_1_7= Param
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

            // InternalRos1Parser.g:7875:3: ( ( ruleEString ) )
            // InternalRos1Parser.g:7876:4: ( ruleEString )
            {
            // InternalRos1Parser.g:7876:4: ( ruleEString )
            // InternalRos1Parser.g:7877:5: ruleEString
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
    // InternalRos1Parser.g:7895:1: entryRuleExtensionScalarValue returns [EObject current=null] : iv_ruleExtensionScalarValue= ruleExtensionScalarValue EOF ;
    public final EObject entryRuleExtensionScalarValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionScalarValue = null;


        try {
            // InternalRos1Parser.g:7895:61: (iv_ruleExtensionScalarValue= ruleExtensionScalarValue EOF )
            // InternalRos1Parser.g:7896:2: iv_ruleExtensionScalarValue= ruleExtensionScalarValue EOF
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
    // InternalRos1Parser.g:7902:1: ruleExtensionScalarValue returns [EObject current=null] : ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) ) ;
    public final EObject ruleExtensionScalarValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:7908:2: ( ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) ) )
            // InternalRos1Parser.g:7909:2: ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) )
            {
            // InternalRos1Parser.g:7909:2: ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) )
            // InternalRos1Parser.g:7910:3: () ( (lv_value_1_0= ruleExtensionScalarLiteral ) )
            {
            // InternalRos1Parser.g:7910:3: ()
            // InternalRos1Parser.g:7911:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionScalarValueAccess().getExtensionScalarValueAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:7917:3: ( (lv_value_1_0= ruleExtensionScalarLiteral ) )
            // InternalRos1Parser.g:7918:4: (lv_value_1_0= ruleExtensionScalarLiteral )
            {
            // InternalRos1Parser.g:7918:4: (lv_value_1_0= ruleExtensionScalarLiteral )
            // InternalRos1Parser.g:7919:5: lv_value_1_0= ruleExtensionScalarLiteral
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
    // InternalRos1Parser.g:7940:1: entryRuleExtensionScalarLiteral returns [String current=null] : iv_ruleExtensionScalarLiteral= ruleExtensionScalarLiteral EOF ;
    public final String entryRuleExtensionScalarLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionScalarLiteral = null;


        try {
            // InternalRos1Parser.g:7940:62: (iv_ruleExtensionScalarLiteral= ruleExtensionScalarLiteral EOF )
            // InternalRos1Parser.g:7941:2: iv_ruleExtensionScalarLiteral= ruleExtensionScalarLiteral EOF
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
    // InternalRos1Parser.g:7947:1: ruleExtensionScalarLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey ) ;
    public final AntlrDatatypeRuleToken ruleExtensionScalarLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BOOLEAN_0=null;
        Token this_DOUBLE_1=null;
        Token this_DECINT_2=null;
        Token this_INT_3=null;
        AntlrDatatypeRuleToken this_ExtensionKey_4 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:7953:2: ( (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey ) )
            // InternalRos1Parser.g:7954:2: (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey )
            {
            // InternalRos1Parser.g:7954:2: (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey )
            int alt122=5;
            switch ( input.LA(1) ) {
            case RULE_BOOLEAN:
                {
                alt122=1;
                }
                break;
            case RULE_DOUBLE:
                {
                alt122=2;
                }
                break;
            case RULE_DECINT:
                {
                alt122=3;
                }
                break;
            case RULE_INT:
                {
                alt122=4;
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
                alt122=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 122, 0, input);

                throw nvae;
            }

            switch (alt122) {
                case 1 :
                    // InternalRos1Parser.g:7955:3: this_BOOLEAN_0= RULE_BOOLEAN
                    {
                    this_BOOLEAN_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_2); 

                    			current.merge(this_BOOLEAN_0);
                    		

                    			newLeafNode(this_BOOLEAN_0, grammarAccess.getExtensionScalarLiteralAccess().getBOOLEANTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:7963:3: this_DOUBLE_1= RULE_DOUBLE
                    {
                    this_DOUBLE_1=(Token)match(input,RULE_DOUBLE,FOLLOW_2); 

                    			current.merge(this_DOUBLE_1);
                    		

                    			newLeafNode(this_DOUBLE_1, grammarAccess.getExtensionScalarLiteralAccess().getDOUBLETerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRos1Parser.g:7971:3: this_DECINT_2= RULE_DECINT
                    {
                    this_DECINT_2=(Token)match(input,RULE_DECINT,FOLLOW_2); 

                    			current.merge(this_DECINT_2);
                    		

                    			newLeafNode(this_DECINT_2, grammarAccess.getExtensionScalarLiteralAccess().getDECINTTerminalRuleCall_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRos1Parser.g:7979:3: this_INT_3= RULE_INT
                    {
                    this_INT_3=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			current.merge(this_INT_3);
                    		

                    			newLeafNode(this_INT_3, grammarAccess.getExtensionScalarLiteralAccess().getINTTerminalRuleCall_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRos1Parser.g:7987:3: this_ExtensionKey_4= ruleExtensionKey
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
    // InternalRos1Parser.g:8001:1: rulePluginSlotValueFormat returns [Enumerator current=null] : ( (enumLiteral_0= Class ) | (enumLiteral_1= Library ) ) ;
    public final Enumerator rulePluginSlotValueFormat() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:8007:2: ( ( (enumLiteral_0= Class ) | (enumLiteral_1= Library ) ) )
            // InternalRos1Parser.g:8008:2: ( (enumLiteral_0= Class ) | (enumLiteral_1= Library ) )
            {
            // InternalRos1Parser.g:8008:2: ( (enumLiteral_0= Class ) | (enumLiteral_1= Library ) )
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==Class) ) {
                alt123=1;
            }
            else if ( (LA123_0==Library) ) {
                alt123=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 123, 0, input);

                throw nvae;
            }
            switch (alt123) {
                case 1 :
                    // InternalRos1Parser.g:8009:3: (enumLiteral_0= Class )
                    {
                    // InternalRos1Parser.g:8009:3: (enumLiteral_0= Class )
                    // InternalRos1Parser.g:8010:4: enumLiteral_0= Class
                    {
                    enumLiteral_0=(Token)match(input,Class,FOLLOW_2); 

                    				current = grammarAccess.getPluginSlotValueFormatAccess().getCLASSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPluginSlotValueFormatAccess().getCLASSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:8017:3: (enumLiteral_1= Library )
                    {
                    // InternalRos1Parser.g:8017:3: (enumLiteral_1= Library )
                    // InternalRos1Parser.g:8018:4: enumLiteral_1= Library
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


    protected DFA83 dfa83 = new DFA83(this);
    protected DFA100 dfa100 = new DFA100(this);
    static final String dfa_1s = "\15\uffff";
    static final String dfa_2s = "\1\12\4\13\10\uffff";
    static final String dfa_3s = "\5\17\4\uffff\1\43\3\uffff";
    static final String dfa_4s = "\5\154\4\uffff\1\153\3\uffff";
    static final String dfa_5s = "\5\uffff\1\2\1\3\1\4\1\5\1\uffff\1\7\1\1\1\6";
    static final String dfa_6s = "\15\uffff}>";
    static final String[] dfa_7s = {
            "\1\12\1\uffff\1\12\3\uffff\1\12\1\uffff\1\12\4\uffff\1\12\5\uffff\1\12\1\4\21\uffff\1\12\1\3\35\uffff\1\12\3\uffff\1\11\1\12\3\uffff\1\5\1\10\1\6\1\7\6\uffff\1\2\1\1\3\uffff\1\12",
            "\1\13\1\uffff\1\13\3\uffff\1\13\1\uffff\1\13\4\uffff\1\13\5\uffff\2\13\21\uffff\2\13\35\uffff\1\13\1\uffff\1\12\2\uffff\1\13\15\uffff\2\13\3\uffff\1\13",
            "\1\13\1\uffff\1\13\3\uffff\1\13\1\uffff\1\13\4\uffff\1\13\5\uffff\2\13\21\uffff\2\13\35\uffff\1\13\1\uffff\1\12\2\uffff\1\13\15\uffff\2\13\3\uffff\1\13",
            "\1\13\1\uffff\1\13\3\uffff\1\13\1\uffff\1\13\4\uffff\1\13\5\uffff\2\13\21\uffff\2\13\35\uffff\1\13\1\uffff\1\12\2\uffff\1\13\15\uffff\2\13\3\uffff\1\13",
            "\1\13\1\uffff\1\13\3\uffff\1\13\1\uffff\1\13\4\uffff\1\13\5\uffff\2\13\21\uffff\2\13\35\uffff\1\13\1\uffff\1\12\2\uffff\1\13\15\uffff\2\13\3\uffff\1\13",
            "",
            "",
            "",
            "",
            "\1\14\22\uffff\1\14\35\uffff\1\14\3\uffff\2\14\3\uffff\4\14\6\uffff\2\14\2\uffff\1\12",
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

    class DFA83 extends DFA {

        public DFA83(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 83;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "4160:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )";
        }
    }
    static final String dfa_8s = "\62\uffff";
    static final String dfa_9s = "\1\uffff\15\16\1\uffff\5\16\36\uffff";
    static final String dfa_10s = "\16\32\1\uffff\5\32\17\123\17\uffff";
    static final String dfa_11s = "\1\150\15\152\1\uffff\5\152\17\137\17\uffff";
    static final String dfa_12s = "\16\uffff\1\1\24\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20";
    static final String dfa_13s = "\62\uffff}>";
    static final String[] dfa_14s = {
            "\1\16\5\uffff\1\12\1\13\1\uffff\1\22\6\uffff\1\16\4\uffff\1\14\1\5\1\7\1\11\3\uffff\1\21\1\4\1\6\1\10\6\uffff\1\3\5\uffff\1\1\1\15\1\23\1\uffff\1\2\4\uffff\1\16\27\uffff\1\20\1\17",
            "\2\16\7\uffff\2\16\2\uffff\1\16\5\uffff\2\16\7\uffff\1\16\12\uffff\1\16\7\uffff\1\16\1\uffff\1\16\3\uffff\2\16\7\uffff\1\24\16\uffff\2\16\1\uffff\1\16",
            "\2\16\7\uffff\2\16\2\uffff\1\16\5\uffff\2\16\7\uffff\1\16\12\uffff\1\16\7\uffff\1\16\1\uffff\1\16\3\uffff\2\16\7\uffff\1\25\16\uffff\2\16\1\uffff\1\16",
            "\2\16\7\uffff\2\16\2\uffff\1\16\5\uffff\2\16\7\uffff\1\16\12\uffff\1\16\7\uffff\1\16\1\uffff\1\16\3\uffff\2\16\7\uffff\1\26\16\uffff\2\16\1\uffff\1\16",
            "\2\16\7\uffff\2\16\2\uffff\1\16\5\uffff\2\16\7\uffff\1\16\12\uffff\1\16\7\uffff\1\16\1\uffff\1\16\3\uffff\2\16\7\uffff\1\27\16\uffff\2\16\1\uffff\1\16",
            "\2\16\7\uffff\2\16\2\uffff\1\16\5\uffff\2\16\7\uffff\1\16\12\uffff\1\16\7\uffff\1\16\1\uffff\1\16\3\uffff\2\16\7\uffff\1\30\16\uffff\2\16\1\uffff\1\16",
            "\2\16\7\uffff\2\16\2\uffff\1\16\5\uffff\2\16\7\uffff\1\16\12\uffff\1\16\7\uffff\1\16\1\uffff\1\16\3\uffff\2\16\7\uffff\1\31\16\uffff\2\16\1\uffff\1\16",
            "\2\16\7\uffff\2\16\2\uffff\1\16\5\uffff\2\16\7\uffff\1\16\12\uffff\1\16\7\uffff\1\16\1\uffff\1\16\3\uffff\2\16\7\uffff\1\32\16\uffff\2\16\1\uffff\1\16",
            "\2\16\7\uffff\2\16\2\uffff\1\16\5\uffff\2\16\7\uffff\1\16\12\uffff\1\16\7\uffff\1\16\1\uffff\1\16\3\uffff\2\16\7\uffff\1\33\16\uffff\2\16\1\uffff\1\16",
            "\2\16\7\uffff\2\16\2\uffff\1\16\5\uffff\2\16\7\uffff\1\16\12\uffff\1\16\7\uffff\1\16\1\uffff\1\16\3\uffff\2\16\7\uffff\1\34\16\uffff\2\16\1\uffff\1\16",
            "\2\16\7\uffff\2\16\2\uffff\1\16\5\uffff\2\16\7\uffff\1\16\12\uffff\1\16\7\uffff\1\16\1\uffff\1\16\3\uffff\2\16\7\uffff\1\35\16\uffff\2\16\1\uffff\1\16",
            "\2\16\7\uffff\2\16\2\uffff\1\16\5\uffff\2\16\7\uffff\1\16\12\uffff\1\16\7\uffff\1\16\1\uffff\1\16\3\uffff\2\16\7\uffff\1\36\16\uffff\2\16\1\uffff\1\16",
            "\2\16\7\uffff\2\16\2\uffff\1\16\5\uffff\2\16\7\uffff\1\16\12\uffff\1\16\7\uffff\1\16\1\uffff\1\16\3\uffff\2\16\7\uffff\1\37\16\uffff\2\16\1\uffff\1\16",
            "\2\16\7\uffff\2\16\2\uffff\1\16\5\uffff\2\16\7\uffff\1\16\12\uffff\1\16\7\uffff\1\16\1\uffff\1\16\3\uffff\2\16\7\uffff\1\40\16\uffff\2\16\1\uffff\1\16",
            "",
            "\2\16\7\uffff\2\16\2\uffff\1\16\5\uffff\2\16\7\uffff\1\16\12\uffff\1\16\7\uffff\1\16\1\uffff\1\16\3\uffff\2\16\7\uffff\1\41\16\uffff\2\16\1\uffff\1\16",
            "\2\16\7\uffff\2\16\2\uffff\1\16\5\uffff\2\16\7\uffff\1\16\12\uffff\1\16\7\uffff\1\16\1\uffff\1\16\3\uffff\2\16\7\uffff\1\41\16\uffff\2\16\1\uffff\1\16",
            "\2\16\7\uffff\2\16\2\uffff\1\16\5\uffff\2\16\7\uffff\1\16\12\uffff\1\16\7\uffff\1\16\1\uffff\1\16\3\uffff\2\16\7\uffff\1\41\16\uffff\2\16\1\uffff\1\16",
            "\2\16\7\uffff\2\16\2\uffff\1\16\5\uffff\2\16\7\uffff\1\16\12\uffff\1\16\7\uffff\1\16\1\uffff\1\16\3\uffff\2\16\7\uffff\1\41\16\uffff\2\16\1\uffff\1\16",
            "\2\16\7\uffff\2\16\2\uffff\1\16\5\uffff\2\16\7\uffff\1\16\12\uffff\1\16\7\uffff\1\16\1\uffff\1\16\3\uffff\2\16\7\uffff\1\42\16\uffff\2\16\1\uffff\1\16",
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
            "\1\16\5\uffff\1\60\5\uffff\1\16",
            "\1\16\5\uffff\1\61\5\uffff\1\16",
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

    class DFA100 extends DFA {

        public DFA100(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 100;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "5519:2: ( (this_ScalarType_0= ruleScalarType ( () otherlv_2= LeftSquareBracket ( (lv_bounded_3_0= LessThanSignEqualsSign ) )? ( (lv_size_4_0= ruleArraySize ) ) otherlv_5= RightSquareBracket )? ) | this_boolArray_6= ruleboolArray | this_int8Array_7= ruleint8Array | this_uint8Array_8= ruleuint8Array | this_int16Array_9= ruleint16Array | this_uint16Array_10= ruleuint16Array | this_int32Array_11= ruleint32Array | this_uint32Array_12= ruleuint32Array | this_int64Array_13= ruleint64Array | this_uint64Array_14= ruleuint64Array | this_float32Array_15= rulefloat32Array | this_float64Array_16= rulefloat64Array | this_string0Array_17= rulestring0Array | this_byteArray_18= rulebyteArray | this_ArraySpecRef_19= ruleArraySpecRef | this_charArray_20= rulecharArray )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000105000L,0x0000100000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0040000800000000L,0x0000018000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000101000L,0x0000100000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0060000C10A28000L,0x0000508000001000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000001000L,0x0000100000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0040000800000010L,0x0000018000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000002100000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x2400000001005000L,0x0000100000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x2400000001001000L,0x0000100000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x2400000001000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00400C0800000000L,0x0000118000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0040000800000000L,0x0000118000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x0000180000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x03C7840B04000000L,0x00001180000085C1L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000020000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000400000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000008000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x03C7840B04000002L,0x00000180000085C1L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0800000010000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0040000800000000L,0x0000408000001000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x00000000000D8F02L,0x0000000000800000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0060000C10A28000L,0x0000518000001000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0000018000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x00000000000D8F00L,0x0000100000800000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000080004000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0020000402A00000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0020000402A00000L,0x0000100000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0040000800000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000200000L,0x0000000000100000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000402800000L,0x0000000008100000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000002800000L,0x0000000008100000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000002000000L,0x0000000008100000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000100000040000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x8000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x00101B00C0000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0008000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0040000800000000L,0x00000181E1000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0060000C10A28000L,0x0000418002001000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x004060980C000000L,0x0000058000018A02L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000080080000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000002L,0x0000000100200000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000002L,0x0000008100200000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000002L,0x0000080004000000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0xAFFFFF9FDFAFDF00L,0x0000418000079FCFL});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0xAFFFFF9FDFAFDF00L,0x0000518000079FCFL});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0xAFFFFF9FDFAFDF00L,0x0000418008079FCFL});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0xAFFFFF9FDFAFDF00L,0x0000418008179FCFL});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x53D7FFBBCC000000L,0x00000B81C503FFFFL});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x53D7FFBBCC000000L,0x00000B81C703FFFFL});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x53D7FFBBCC000000L,0x00000B81C713FFFFL});

}
