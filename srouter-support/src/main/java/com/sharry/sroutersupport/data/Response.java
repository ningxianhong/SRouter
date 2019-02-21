package com.sharry.sroutersupport.data;

import android.support.v4.app.Fragment;

import com.sharry.sroutersupport.providers.IProvider;

/**
 * The result associated with a navigation.
 *
 * @author Sharry <a href="xiaoyu.zhu@1hai.cn">Contact me.</a>
 * @version 1.0
 * @since 2/20/2019 10:41 AM
 */
public class Response {

    private Fragment fragmentV4;
    private android.app.Fragment fragment;
    private IProvider provider;

    public Fragment getFragmentV4() {
        return fragmentV4;
    }

    public void setFragmentV4(Fragment fragmentV4) {
        this.fragmentV4 = fragmentV4;
    }

    public android.app.Fragment getFragment() {
        return fragment;
    }

    public void setFragment(android.app.Fragment fragment) {
        this.fragment = fragment;
    }

    public IProvider getProvider() {
        return provider;
    }

    public void setProvider(IProvider provider) {
        this.provider = provider;
    }
}