package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TransferAggregator {

    private Map<String, TransferPerClient> result = new TreeMap<>();

    public List<TransferPerClient> readTransfers(Path path) {
        List<String> temp = readLines(path);
        mapTransactions(temp);
        return summarize();
    }

    private List<String> readLines(Path path) {
        List<String> temp = new ArrayList<>();
        try (BufferedReader bf = Files.newBufferedReader(path)) {
            String line;
            while ((line = bf.readLine()) != null) {
                temp.add(line);
            }
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("File can not be read.");
        }
        return temp;
    }

    private List<TransferPerClient> summarize() {
/*        List<TransferPerClient> output = new ArrayList<>();
        for (Map.Entry<String, TransferPerClient> entry : result.entrySet()) {
            output.add(entry.getValue());
        }
        return output;*/
        return new ArrayList<>(result.values());
    }

    private Map<String, TransferPerClient> mapTransactions(List<String> data) {
        for (String line : data) {
            String senderID = line.split("\t")[0].trim();
            String receiverID = line.split("\t")[1].trim();
            int amount = Integer.parseInt(line.split("\t")[2].trim());

            updateSender(senderID, amount);
            updateReceiver(receiverID, amount);
        }
        return result;
    }

    private void updateSender(String senderID, int amount) {
        if (result.containsKey(senderID)) {
            result.put(senderID, result.get(senderID).decrease(amount));
        } else {
            result.put(senderID, new TransferPerClient(senderID, -amount, 1));
        }
    }

    private void updateReceiver(String receiverID, int amount) {
        if (result.containsKey(receiverID)) {
            result.put(receiverID, result.get(receiverID).increase(amount));
        } else {
            result.put(receiverID, new TransferPerClient(receiverID, amount, 1));
        }
    }
}
