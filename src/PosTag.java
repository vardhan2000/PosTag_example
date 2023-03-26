import java.io.File;

import opennlp.tools.cmdline.postag.POSModelLoader;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.stemmer.PorterStemmer;
import opennlp.tools.tokenize.SimpleTokenizer;

public class PosTag {
	public static void main(String[] args) throws Exception {
//		System.out.println("Hello");
		
//		This line creates an instance of the POSModel class, which represents a
//		pre-trained model for part-of-speech tagging. The model is loaded from a
//		file on the local file system.
		POSModel model = new POSModelLoader().load(new File("/Users/adityav/Desktop/8/NoSQL/assns/assn-2/opennlp-en-ud-ewt-pos-1.0-1.9.3.bin")); //Edit path to the pre-trained model file

//		This line creates an instance of the POSTaggerME class, which is used to
//		perform part-of-speech tagging on a given input sentence. The tagger is
//		initialized with the pre-trained model.
		POSTaggerME tagger = new POSTaggerME(model);

		String line = "Can anyone help me dig through OpenNLP's documentation?";
		if (line != null) {
			SimpleTokenizer tokenizer = SimpleTokenizer.INSTANCE;
	    	String tokenizedLine[] = tokenizer.tokenize(line); //Tokenize line

//			This line performs part-of-speech tagging on the tokenized input sentence
//			using the tag() method of the POSTaggerME class. The method returns an
//			array of POS tags, one for each word in the input sentence.
	    	String[] tags = tagger.tag(tokenizedLine); //Instanciate tags

			//POS Tag
	    	POSSample sample = new POSSample(tokenizedLine, tags); //Identify tags
	    	System.out.println("\n\n" + sample.toString()); //Print tagged sentence
			for(String token : sample.getTags()){
				System.out.println(token); //Print tags of words
		  	}
			System.out.println("\n\nSteammed words:");
			//Steammer
			PorterStemmer steammer = new PorterStemmer(); // Instanciate Steammer
			for(String token : tokenizedLine){
				System.out.println(steammer.stem(token).toString());
			}

		}
		return;
	}
}
