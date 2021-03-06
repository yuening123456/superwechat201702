package cn.ucai.superwechat.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hyphenate.easeui.domain.User;
import com.hyphenate.easeui.ui.EaseBaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.ucai.superwechat.R;
import cn.ucai.superwechat.SuperWeChatHelper;

/**
 * Created by clawpo on 2017/5/23.
 */

public class ProfileFragment extends EaseBaseFragment {

    @BindView(R.id.iv_profile_avatar)
    ImageView mIvProfileAvatar;
    @BindView(R.id.tv_profile_nickname)
    TextView mTvProfileNickname;
    @BindView(R.id.tv_profile_username)
    TextView mTvProfileUsername;
    Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        bind = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setUpView() {
        titleBar.setRightImageResource(R.drawable.em_add);
        titleBar.setTitle(getString(R.string.me));
        User user = SuperWeChatHelper.getInstance().getUserProfileManager().getCurrentAppUserInfo();
        if (user!=null){
            mTvProfileNickname.setText(user.getMUserNick());
            mTvProfileUsername.setText("微信号: " +user.getMUserName());
            if(!TextUtils.isEmpty(user.getAvatar())){
                Glide.with(getContext()).load(user.getAvatar()).placeholder(R.drawable.em_default_avatar).into(mIvProfileAvatar);
            }else{
                Glide.with(getContext()).load(R.drawable.em_default_avatar).into(mIvProfileAvatar);
            }
        }
    }

    @OnClick({R.id.layout_profile_view, R.id.tv_profile_money, R.id.tv_profile_settings})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_profile_view:
                break;
            case R.id.tv_profile_money:
                break;
            case R.id.tv_profile_settings:
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (bind!=null){
            bind.unbind();
        }
    }
}
