// Generated code from Butter Knife. Do not modify!
package com.parse.starter.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LogInActivity$$ViewBinder<T extends com.parse.starter.ui.LogInActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492946, "field 'mTxtUsername'");
    target.mTxtUsername = finder.castView(view, 2131492946, "field 'mTxtUsername'");
    view = finder.findRequiredView(source, 2131492947, "field 'mTxtPassword'");
    target.mTxtPassword = finder.castView(view, 2131492947, "field 'mTxtPassword'");
    view = finder.findRequiredView(source, 2131492948, "field 'mBtnSubmit'");
    target.mBtnSubmit = finder.castView(view, 2131492948, "field 'mBtnSubmit'");
    view = finder.findRequiredView(source, 2131492949, "field 'mTxtSubmit'");
    target.mTxtSubmit = finder.castView(view, 2131492949, "field 'mTxtSubmit'");
  }

  @Override public void unbind(T target) {
    target.mTxtUsername = null;
    target.mTxtPassword = null;
    target.mBtnSubmit = null;
    target.mTxtSubmit = null;
  }
}
