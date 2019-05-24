package co.mateusbello;

import java.util.List;
import java.util.Stack;

import co.mateusbello.exception.ResourceException;
import co.mateusbello.util.Resource;
import co.mateusbello.util.TextFile;

public class FindCelebrity {

    public static void main(String[] args) {
        Resource resource = new TextFile();
        try {
            //Load people's data from file
            List<String> data = resource.loadData();
            Stack<Integer> people = pushPeopleIntoStack(data.size());
            int[][] matrix = buildMatrix(data);
            
            System.out.println("Celebrity is in position -->"+findCelebrity(people, matrix));
            
        } catch (ResourceException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }

    }
    
    /**
     * Process all the people to check if there is a celebrity
     * @param people, stack to process
     * @param matrix, array that contains if a person is known or not
     * @return -1 if there is not a celebrity, else celebrity's position
     */
    private static int findCelebrity(Stack<Integer> people, int[][] matrix) {
        while (people.size() > 1) {
            //get two elements to compare
            int first = people.pop();
            int second = people.pop();
            
            if (matrix[first][second] == 1) {
                people.push(second);
            }else {
                people.push(first);
            }
        }
        
        int last = people.pop();
        for (int i=0; i< people.size(); i++) {
            if (i!=last & (matrix[last][i] == 1) || matrix[i][last] != 1) {
                return -1;
            }
        }
        return last;
    }
    
    /**
     * Build matrix that contains if person is known or not
     * @param data
     * @return
     */
    private static int[][] buildMatrix(List<String> data) {
        int[][] matrix = new int[data.size()][data.size()];
        for (int i= 0; i < data.size() ; i++) {
            for (int j= 0; j < data.size() ; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                }else {
                    matrix[i][j] = Integer.parseInt(data.get(j));
                }
            }
        }
        
        return matrix;
    }
    
    
    /**
     * Push people into stack to be processed
     * @param total, number of people
     * @return Stack with people
     */
    private static Stack<Integer> pushPeopleIntoStack(Integer total){
        Stack<Integer> people = new Stack<>();
        for (int current = 0; current < total ; current++) {
            people.push(current);
        }
        return people;
    }
    

}
