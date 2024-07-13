package data_access.database_transaction_entry;

import entity.TransactionEntry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class DataTransactionEntryDataAccessObject implements DatabaseTransactionEntryDataAccessInterface{
    private static int transactionID = 0;

//    @Override
//     //input the transaction id and return TransactionEntry
//    public TransactionEntry getTransactionEntry(int id) {
//        JSONParser parser = new JSONParser();
//        try{
//            Object obj = parser.parse(new FileReader("/Users/sakuramao/Desktop/Book_Transaction/src/main/java/data/PurchaseTransaction.json"));
//            JSONObject jsonObject = (JSONObject) obj;
//            // convert the int to string
//            String key = Integer.toString(id);
//
//            // check if the id inside the json file
//            if (jsonObject.containsKey(key)) {
//                JSONObject transaction = (JSONObject) jsonObject.get(key);
//
//                TransactionEntry foundTransaction = new TransactionEntry(transaction.get())
//            }
//
//        }
//        catch(Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }


    @Override
    public boolean createTransactionEntry(TransactionEntry transactionEntry) {
        JSONObject jsonObject;
        // get the outer object of whole json file
        JSONParser parser = new JSONParser();

        try{
            Object obj = parser.parse(new FileReader("/Users/sakuramao/Desktop/Book_Transaction/src/main/java/data/PurchaseTransaction.json"));
            jsonObject = (JSONObject) obj;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }

        // create a 'small' JSONObject
        JSONObject transactionJSONObject = new JSONObject();
        transactionJSONObject.put("bookid", transactionEntry.getBookId());
        transactionJSONObject.put("price", transactionEntry.getSoldPrice());
        transactionJSONObject.put("date", transactionEntry.getDate());

        // Write the small json object to file
        int num = transactionEntry.getTransactionId();
        String stringNum = Integer.toString(num);
        jsonObject.put(stringNum, transactionJSONObject);
        try (FileWriter file = new FileWriter("/Users/sakuramao/Desktop/Book_Transaction/src/main/java/data/PurchaseTransaction.json")){
            file.write(jsonObject.toJSONString());
            file.flush();
            return true;
        }
        // fail to write the object into the json file
        catch(IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    // create TransactionID
    public int createTransactionID(){
        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(new FileReader("/Users/sakuramao/Desktop/Book_Transaction/src/main/java/data/PurchaseTransaction.json"));
            JSONObject jsonObject = (JSONObject) obj;
            // check if the target obj in the database
            while(jsonObject.containsKey(Integer.toString(transactionID))){
                transactionID++;
            }
            return transactionID;
        }
        catch(Exception e){
            e.printStackTrace();
            return -1;
        }


    }
}
