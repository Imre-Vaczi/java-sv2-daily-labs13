package day05;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransferAggregatorTest {

    @Test
    void testSummarize() {
        Path path = Paths.get("src/main/resources/transfer.csv");
        TransferAggregator ta = new TransferAggregator();

        List<TransferPerClient> result = ta.readTransfers(path);

        for (TransferPerClient tf : result) {
            System.out.printf("%s %12s %5d", tf.getClientID(), tf.getSum(), tf.getNumOfTrans());
            System.out.println();
        }
    }

}