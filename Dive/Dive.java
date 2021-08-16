public class Dive {
    int minJudge,maxJudge,minScore,maxScore,sum;
    private static int score[];
    Dive(int [] data) {
        score=data;
    }
    void setScore (int i, int s) {
    score [i]=s;
    }
    static int getScore(int i){//метод гет
        return score[i];}

    void assessScores() {
        minScore = 10;
        maxScore = 0;
        sum = 0;

        for(int i=0; i<score.length; i++)
        {sum+=score[i];
            if(score[i]<minScore)
            {minScore=score[i];
                minJudge=i;}
            if(score[i]>maxScore){maxScore=score[i];
                maxJudge=i;}}
        minJudge++;
        maxJudge++;

    }
}


