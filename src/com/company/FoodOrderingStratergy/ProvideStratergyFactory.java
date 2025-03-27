package com.company.FoodOrderingStratergy;

public class ProvideStratergyFactory{

    public ProvideStratergyFactory(){}

    public enum StratergyEnum{
        HIGHEST_RATING, LOWEST_COST;
    }

    public static SelectionStratergy provideStratergy(StratergyEnum input){
        if(input.equals(StratergyEnum.HIGHEST_RATING)){
            return new HighRatingStatergy();
        }else return new LowCostStratergy();
    }
}
