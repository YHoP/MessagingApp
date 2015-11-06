// Generated code from Butter Knife. Do not modify!
package com.parse.starter.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MessageActivity$$ViewBinder<T extends com.parse.starter.ui.MessageActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492945, "field 'mTxtTitle'");
    target.mTxtTitle = finder.castView(view, 2131492945, "field 'mTxtTitle'");
    view = finder.findRequiredView(source, 2131492946, "field 'mTxtUsername'");
    target.mTxtUsername = finder.castView(view, 2131492946, "field 'mTxtUsername'");
    view = finder.findRequiredView(source, 2131492951, "field 'mTxtMessage'");
    target.mTxtMessage = finder.castView(view, 2131492951, "field 'mTxtMessage'");
    view = finder.findRequiredView(source, 2131492952, "field 'mTxtPostDate'");
    target.mTxtPostDate = finder.castView(view, 2131492952, "field 'mTxtPostDate'");
  }

  @Override public void unbind(T target) {
    target.mTxtTitle = null;
    target.mTxtUsername = null;
    target.mTxtMessage = null;
    target.mTxtPostDate = null;
  }
}
