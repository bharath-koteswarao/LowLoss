package com.myartsonline.bharath.lowloss.RewardsRecyclerView;

/**
 * Created by bk on 14-04-2017.
 */

public class ListItem {
    private String name,score,rank;

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }

    public String getRank() {
        return rank;
    }

    public ListItem(String name, String score, String rank)
    {
        this.name=name;
        this.score=score;
        this.rank=rank;
    }
}
