// Generated code from Butter Knife. Do not modify!
package com.parse.starter.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class NewMessageActivity$$ViewBinder<T extends com.parse.starter.ui.NewMessageActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492953, "field 'mEditTitle'");
    target.mEditTitle = finder.castView(view, 2131492953, "field 'mEditTitle'");
    view = finder.findRequiredView(source, 2131492954, "field 'mEditMessage'");
    target.mEditMessage = finder.castView(view, 2131492954, "field 'mEditMessage'");
    view = finder.findRequiredView(source, 2131492955, "field 'mSubmitButton'");
    target.mSubmitButton = finder.castView(view, 2131492955, "field 'mSubmitButton'");
    view = finder.findRequiredView(source, 2131492943, "field 'mRelativeLayout'");
    target.mRelativeLayout = finder.castView(view, 2131492943, "field 'mRelativeLayout'");
  }

  @Override public void unbind(T target) {
    target.mEditTitle = null;
    target.mEditMessage = null;
    target.mSubmitButton = null;
    target.mRelativeLayout = null;
  }
}
