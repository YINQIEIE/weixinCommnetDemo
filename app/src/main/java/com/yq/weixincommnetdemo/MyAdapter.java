package com.yq.weixincommnetdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/20.
 */

public class MyAdapter extends Adapter {

    public static final int TYPE_TOP = 0;
    public static final int TYPE_NORMAL = 1;

    private Context mContext;
    private List data = new ArrayList();

    public MyAdapter(Context mContext) {
        this.mContext = mContext;
        data.add(new TopBean());
        data.add(new NormalBean("中兴禁购事件还在持续发酵。今天中兴通讯再发停牌公告，称将积极、合法寻求被美国禁售的解决方案。虽然中兴只有25%-30%的零部件来自美国供应商，但手机芯片、基带芯片、射频芯片、存储芯片、手机玻璃、光学元件等最为核心的零部件都依赖于美国供应商。因此，这次禁令对中兴的影响非常大。"));
        data.add(new NormalBean("央视评论称，中兴通讯与数百家美国企业开展了广泛的贸易投资合作，为美国贡献了数以万计的就业岗位。美国此番作为无疑是搬起石头砸自己的脚。 7 年禁令影响的不但是中兴设备的生产，美国也将丧失数以万计的就业机会，而且还会影响成百上千的美国关联企业，将会动摇国际社会对美国投资和营商环境稳定的信心。"));
        data.add(new NormalBean("同时，央视称此次美方制裁尺度太不正常，质疑美国并不只是封杀中兴这么简单，而是将矛头指向了中国电信设备制造商，意图阻碍中国运营商网络建设发展。"));
        data.add(new NormalBean("央视评论：美国封杀中兴恐怕还有弦外之音 日前，美国商务部宣布对中兴公司采取出口管制措施。这里，有一个问题我们必须要想清楚，美国究竟是要封杀中兴，还是指向了中国电信设备制造商？美国之前制裁中兴，理由是中兴向伊朗出售美国技术，双方后来达成和解，但中兴需要支付约8.9亿美元的刑事和民事罚金。"));
        data.add(new NormalBean("此次，美方封杀中兴的理由是其没有严格履行和解协议，只解雇了四名高级雇员，未处罚或减少35名员工奖金，这就是所谓的“实锤”。\n" +
                "按理，中国不是美国的盟友，现在也不是冷战时代，中国公司并没有义务执行美方的决议。但美国之强势，又是许多大型公司不得不考虑的现实，许多和美国达成所谓“和解”的公司私底下都是一肚子苦水。"));
        data.add(new NormalBean("和中兴遭制裁相比较，有一个相似的例子是在20世纪80年代中期，美国对向苏联出口数控机床的东芝公司下了3年禁令，不让东芝机械公司的产品进入美国市场。中兴与美方的和解方案是缴纳巨额罚金，而东芝当时则是与美方分享了在军工方面的一些技术，用于双方合作新型战斗机。拿东芝事件来看，制裁就是美方依据其制定的规则来获取利益的手段，因为当时美国认为自己在半导体技术、光纤技术、智能机械技术领域已落后于日本。那么这次中兴事件是不是同样如此呢？至少可以这么说，借题发挥，实锤不实。"));
        data.add(new NormalBean("“即便按美方与中兴的和解协议，美方也有更好、更合理、更适度的处理措施。中方已经注意到美国商务部宣布对中兴公司采取出口管制的措施。中国商务部发言人表示，中方一贯要求中国企业在海外经营过程中，遵守东道国的法律政策，合法合规开展经营。希望美方依法依规，妥善处理，并为企业创造公正、公平、稳定的法律和政策环境。中方之所以提醒美方依法依规，就是在于美方此次小题大做、借题发挥的色彩太过浓重。"));
        data.add(new NormalBean("据悉，中兴通讯已开始逐个确认目前正在进行的每一生产流程、供应链部门或其他活动是否涉及原产美国产品，同时正在向美国商务部申请就禁止出口令的部分内容提供解释性指导。就企业而言，这是一个非常务实的态度，希望问题能尽快得到合理的解决。但我商务部“密切关注事态进展”的表态同样十分重要，我们要随时准备采取必要措施，维护中国企业的合法权益。因为中兴事件的背后不简单。"));
        data.add(new NormalBean("中兴有25%-30%的零部件来自美国供应商，但最为核心的零部件都依赖于美国供应商。中兴的手机芯片、基带芯片、射频芯片、存储芯片、手机玻璃、光学元件等核心零部件都来自于美国的高通、博通、英特尔、美光、甲骨文、康宁等科技巨头，短期内无法找到能保持相同竞争力的替代产品。在中兴通信设备的核心零部件中，基站有的零部件是100%来自美国公司，中兴有1-2个月的备货，如果不在这个时间内和美方达成和解，会影响中兴设备的生产。这对电信行业，特别是中国运营商网络建设会造成影响。这就是我们要问的一个问题，美国究竟是要封杀中兴还是指向了中国电信设备制造商？甚至指向中国通信产业的发展？因为此次美方制裁尺度太不正常，甚至远远超出中兴在美合作伙伴的想象。"));
        data.add(new NormalBean("中兴公司与数百家美国企业开展了广泛的贸易投资合作，为美国贡献了数以万计的就业岗位。美方行径引起了市场对美国贸易和投资环境的普遍担忧，美方的行为表面针对中国，但最终伤害的是美国自身，不仅会使其丧失数以万计的就业机会，还会影响成百上千的美国关联企业，将会动摇国际社会对美国投资和营商环境稳定的信心。"));
        data.add(new NormalBean("中兴事件我们会密切关注，但美方这种连自己企业利益都不顾及的行为的确让我们不寒而栗。同时，也让我们更加清楚一点，必须加大自主研发的决心，加快核心技术突破的脚步。"));
    }

    @Override
    public int getItemViewType(int position) {
        if (data.get(position) instanceof TopBean)
            return TYPE_TOP;
        else
            return TYPE_NORMAL;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case TYPE_TOP:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_top, parent, false);
                return new TopViewHolder(view);
            case TYPE_NORMAL:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_normal, parent, false);
                return new NormalViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_NORMAL:
                ((NormalViewHolder) holder).tv_msg.setText(((NormalBean) data.get(position)).getMsg());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private static class TopViewHolder extends RecyclerView.ViewHolder {

        public TopViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class NormalViewHolder extends RecyclerView.ViewHolder {
        TextView tv_msg;

        public NormalViewHolder(final View itemView) {
            super(itemView);
            tv_msg = itemView.findViewById(R.id.tv_msg);
            itemView.findViewById(R.id.tv_comment).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //这里将整个 itemView 传递过去，position 没用到，留着没什么影响 :)
                    ((MainActivity) mContext).showInputDialog(itemView, getAdapterPosition());
                }
            });
        }
    }

}
