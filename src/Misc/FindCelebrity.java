package Misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindCelebrity {


    public static void main(String[] args) {
//        Suppose you are at a party with n people (labeled from 0 to n - 1) and among them,
//                there may exist one celebrity. The definition of a celebrity is that all
//        the other n - 1 people know him/her but he/she does not know any of them.
//
//                Now you want to find out who the celebrity is or verify that there is not one.
//        The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to
//        get information of whether A knows B. You need to find out the celebrity (or verify there is not one)
//        by asking as few questions as possible (in the asymptotic sense).
//
//               You are given a helper function bool knows(a, b) which tells you whether A knows B.
//                Implement a function int findCelebrity(n). There will be exactly one celebrity if he/she is in the party.
//        Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.


    }

//    It is inductive that we can find the candidate and check whether it is up to standard or not.
//            How do we decide the candidate?
//    We are sure that if A knows B, A cannot be the celebrity while B may be, i.e.,
//    B is the candidate. Since there is only one celebrity, one loop is enough to decide the candidate.
//            How do we check whether the candidate is up to standard?
//    According to the definition of a celebrity, if !knows(i, candidate) || knows(candidate, i) exists,
//    the candidate is not qualified.

    public int findCelebrityBest(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
                System.out.println(candidate);
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == candidate) {
                continue;
            }
            if (!knows(i, candidate) || knows(candidate, i)) {
                return -1;
            }
        }
        return candidate;
    }

    private boolean knows(int candidate, int i) {
        return true;
    }

    public int findCelebrityBruteForce(int n) {
        List<Integer> candidates = new ArrayList<>();

        for(int i = 0; i < n; i++){
            boolean canBe = true;
            for(int j = 0; j < n; j++){
                if(knows(i, j) && i != j){
                    canBe = false;
                    break;
                }
            }
            if(canBe){

                boolean isCeleb = true;
                for(int k = 0; k < n; k++){
                    if(!knows(k, i)){
                        isCeleb = false;
                        break;
                    }
                }
                if(isCeleb)
                    return i;
            }

        }
        return -1;
    }
}
