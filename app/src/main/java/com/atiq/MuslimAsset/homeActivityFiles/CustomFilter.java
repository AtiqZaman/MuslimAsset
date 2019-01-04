package com.atiq.MuslimAsset.homeActivityFiles;

import android.widget.Filter;

import java.util.ArrayList;

public class CustomFilter extends Filter {

    MyAdapter adapter;
    ArrayList<Model> filterList;

    public CustomFilter(ArrayList<Model> filterList, MyAdapter adapter) {
        this.adapter = adapter;
        this.filterList = filterList;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        //Check constraint validity
        if(constraint != null && constraint.length()>0){
            constraint =constraint.toString().toUpperCase();

            //store our filtered model
            ArrayList<Model> filteredModels = new ArrayList<>();
            for (int i = 0; i < filterList.size(); i++) {

                //check
                if(filterList.get(i).getTitleHeading().toUpperCase().contains(constraint)){
                    filteredModels.add(filterList.get(i));
                }
            }
            results.count = filteredModels.size();
            results.values = filteredModels;
        }
        else{
            results.count = filterList.size();
            results.values = filterList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults results) {

        adapter.models = (ArrayList<Model>) results.values;

        //refreash
        adapter.notifyDataSetChanged();

    }
}
