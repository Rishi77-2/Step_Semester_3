package practice_problems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class ExamQuestion {
    String question;
    String correctAnswer;
    String studentAnswer;
    double points;

    ExamQuestion(String question, String correctAnswer,
                 String studentAnswer, double points) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double calculateScore();

    abstract String getType();
}

class MCQQuestion extends ExamQuestion {
    MCQQuestion(String q, String c, String s, double p) {
        super(q, c, s, p);
    }

    double calculateScore() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }

    String getType() {
        return "MCQ";
    }
}

class TrueFalseQuestion extends ExamQuestion {
    TrueFalseQuestion(String q, String c, String s, double p) {
        super(q, c, s, p);
    }

    double calculateScore() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }

    String getType() {
        return "TF";
    }
}

class EssayQuestion extends ExamQuestion {
    EssayQuestion(String q, String c, String s, double p) {
        super(q, c, s, p);
    }

    double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        int matches = 0;
        String answer = studentAnswer.toLowerCase();

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                matches++;
            }
        }

        if (matches >= 2) {
            return points * 0.75;
        } else if (matches == 1) {
            return points * 0.50;
        }

        return 0;
    }

    String getType() {
        return "ESSAY";
    }
}

public class QuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        ExamQuestion[] questions = new ExamQuestion[n];
        Pattern pattern = Pattern.compile("\"([^\"]*)\"");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String type = line.substring(0, line.indexOf(' '));

            Matcher matcher = pattern.matcher(line);
            String[] values = new String[3];
            int index = 0;

            while (matcher.find() && index < 3) {
                values[index++] = matcher.group(1);
            }

            double points = Double.parseDouble(
                    line.substring(line.lastIndexOf(' ') + 1));

            switch (type.toUpperCase()) {
                case "MCQ":
                    questions[i] = new MCQQuestion(
                            values[0], values[1], values[2], points);
                    break;
                case "TF":
                    questions[i] = new TrueFalseQuestion(
                            values[0], values[1], values[2], points);
                    break;
                case "ESSAY":
                    questions[i] = new EssayQuestion(
                            values[0], values[1], values[2], points);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown question type");
            }
        }

        double total = 0;

        for (ExamQuestion q : questions) {
            double score = q.calculateScore();
            System.out.printf("%s: %.2f%n", q.getType(), score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}