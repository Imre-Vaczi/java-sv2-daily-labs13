package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class QuizLogic {

    private Map<QuizObject, List<String>> results = new TreeMap<>();
    private List<String> solutions = new ArrayList<>();
    private Map<QuizObject, Integer> statistics = new TreeMap<>();

    public Map<QuizObject, List<String>> getResults() {
        return results;
    }

    public List<String> getSolutions() {
        return solutions;
    }

    public void fileReader() {

        try (BufferedReader br = Files.newBufferedReader(Path.of("src/main/resources/result.txt"))) {
            String line = br.readLine();
            solutions = List.of(line.split(""));

            while ((line = br.readLine()) != null) {
                QuizObject tempKey = new QuizObject(line.split(" ")[0]);
                String tempNextValue = line.split(" ")[1];
                if (results.containsKey(tempKey)) {
                    List<String> tempValue = results.get(tempKey);
                    tempValue.add(tempNextValue);
                    results.put(tempKey, tempValue);
                } else {
                    List<String> tempVal = new ArrayList<>();
                    tempVal.add(tempNextValue);
                    results.put(tempKey, tempVal);
                }
            }
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("File can not be read.");
        }
        populateStatistics();
    }

    public boolean isCorrect(String code, int question) {
        QuizObject tempKey = findQuizObjectByID(code);
        String answer = getResults().get(tempKey).get(question-1);
        String solution = getSolutions().get(question-1);
        return answer.equals(solution);
    }

    private QuizObject findQuizObjectByID(String code) {
        QuizObject temp;
        for (Map.Entry<QuizObject, List<String>> entry : results.entrySet()) {
            if (entry.getKey().getId().equals(code)) {
                return entry.getKey();
            }
        }
        throw new IllegalStateException("Not found by ID");
    }

    public String getWinnerID() {
        QuizObject tempKey = null;
        Integer tempValue = Integer.MIN_VALUE;
        for (Map.Entry<QuizObject, Integer> entry : statistics.entrySet()) {
            if (entry.getValue() > tempValue) {
                tempKey = entry.getKey();
                tempValue = entry.getValue();
            }
        }
        return tempKey.getId();
    }

    private void populateStatistics() {
        for (Map.Entry<QuizObject, List<String>> entry : results.entrySet()) {
            statistics.put(entry.getKey(), calculateStatistics(entry.getValue()));
        }
    }

    private Integer calculateStatistics(List<String> answers) {
        Integer stat = 0;
        for (int i = 0; i < solutions.size(); i++) {
            if (solutions.get(i).equals(answers.get(i))) {
                stat += i+1;
            } else if (answers.get(i).equals("X")) {
                stat += 0;
            } else {
                stat -= 2;
            }
        }
        return stat;
    }
}
