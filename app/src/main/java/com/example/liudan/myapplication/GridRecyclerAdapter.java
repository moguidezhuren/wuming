package com.example.liudan.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class GridRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPES_FOOTER = 1001;
    private List<Integer> goodsesList;
    private Context context;

    public GridRecyclerAdapter(Context context, List<Integer> goodsesList) {
        this.context = context;
        this.goodsesList = goodsesList;
    }

    @Override
    public int getItemCount() {
        return goodsesList.size();
    }

    public List<Integer> getData() {
        return goodsesList;
    }

    private boolean isShowLoad;



    @Override
    public int getItemViewType(int position) {  //列表类型个数和判断方法
        if (position == goodsesList.size()) {  //foot
            return VIEW_TYPES_FOOTER;
        } else {
            return super.getItemViewType(position);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {  //创建item
        final RecyclerView.ViewHolder recyclerHolder;

            View view = LayoutInflater.from(context).inflate(R.layout.item_grid, null);
            recyclerHolder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerHolder.getAdapterPosition() >= 0) {
//                        Intent intent = new Intent(context, MediaPlayActivity.class);
//                        Bundle mBundle = new Bundle();
//                        mBundle.putSerializable("video", repastList.get(recyclerHolder.getAdapterPosition()));
//                        intent.putExtras(mBundle);
//                        context.startActivity(intent);
                    }
                }
            });

        return recyclerHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder recyclerHolder, int position) { //填充数据

            try {
                ViewHolder viewHolder = (ViewHolder) recyclerHolder;
                if(viewHolder.image!=null){
                    viewHolder.image.setImageDrawable(context.getResources().getDrawable(goodsesList.get(position)));

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }

}
