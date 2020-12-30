package com.example.expandablelistviewexam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomAdapter  extends BaseExpandableListAdapter {
    private Context mContext;
    private ArrayList<String> mParentList;
    private ArrayList<ChildListData> mChildList;
    private ChildListViewHolder mChildListViewHolder;
    private HashMap<String, ArrayList<ChildListData>> mChildHashMap;

    public CustomAdapter(Context context,ArrayList<String>parentList, HashMap<String, ArrayList<ChildListData>> childHashMap)
    {
        this.mContext=context;
        this.mParentList=parentList;
        this.mChildHashMap = childHashMap;
    }

    @Override
    public String getGroup(int groupPosition)
    {
        return mParentList.get(groupPosition);
    }
    @Override
    public int getGroupCount()
    {
        return mParentList.size();
    }
    public long getGroupId(int groupPosition) { // ParentList의 position을 받아 long값으로 반환
        return groupPosition;
    }

    public View getGroupView(int grroupPosition,boolean isExpanded,View convertView,ViewGroup parent)
    {
        if(convertView ==null)
        {
            LayoutInflater grouplnfla= (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = grouplnfla.inflate(R.layout.parent_listview.parent,false);

        }

        TextView parentText = (TextView)convertView.findViewById(R.id.parenttext);
        parentText.setText(getGroup(grroupPosition));
        return convertView;
    }

    public ChildListData getchild(int groupPosition,int childPosition){
        return  this.mChildHashMap.get(this.mParentList.get((groupPosition)).get(childPosition);


    }






    @Override
    public int getChildrenCount(int groupPosition) {
        return 0;
    }



    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }


    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }


    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
