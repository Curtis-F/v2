package com2027.software.group1.groupproject;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class GroupsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.content_groups_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ListView listView = (ListView) getView().findViewById(R.id.groups_list_view);
        if(getActivity().getClass().equals(HomeActivity.class))
        {
            listView.setAdapter(((HomeActivity)getActivity()).getGroupsListAdapter());
        }
        else
        {
            listView.setAdapter(((TargetActivity)getActivity()).getGroupsListAdapter());
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent((getActivity()), GroupsActivity.class);
                if(getActivity().getClass().equals(HomeActivity.class))
                {
                    intent.putExtra("group", ((HomeActivity) getActivity()).getGroups().get(i));
                }
                else
                {
                    intent.putExtra("group", ((TargetActivity) getActivity()).getGroups().get(i));
                }
                startActivity(intent);
            }
        });

    }

}
