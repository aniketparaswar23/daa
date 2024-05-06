import java.util.*;


class Job{
    public int id;
    public int profit;
    public int deadline;
    Job(int id,int profit,int deadline)
    {
        this.deadline=deadline;
        this.id=id;
        this.profit=profit;
    }
    
}

public class jobsequencing {

    public static void main(String args[])
    {
        int maxprofit=0;
        int maxjobs=0;
        Job jobs[]={
            new Job(1,100,2),
            new Job(2,19,1),
            new Job(3,27,2),
            new Job(4,25,1),
            new Job(5,15,3),
            
        };
        Arrays.sort(jobs, Comparator.comparingInt(job -> -job.profit));


        int maxdeadline=0;
        for(int i=0;i<jobs.length;i++)
        {
            if(jobs[i].deadline>maxdeadline)
            {
                maxdeadline=jobs[i].deadline;
            }
        }
        int jobseq[]=new int[maxdeadline+1];
        for(int i=0;i<jobseq.length;i++)
        {
            jobseq[i]=-1;
        }
        for(int i=0;i<jobs.length;i++)
        {
            for(int j=jobs[i].deadline;j>0;j--)
            {
                if(jobseq[j]==-1){
                jobseq[j]=jobs[i].id;
                maxjobs++;
                maxprofit+=jobs[i].profit;
                //System.out.println(maxprofit);
                break;
                }
            }
        }
        System.out.println(maxprofit);
        for(int i=1;i<jobseq.length;i++)
        {
            System.out.print(jobseq[i]+" ");
        }
    }
}
