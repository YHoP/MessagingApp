// Generated code from Butter Knife. Do not modify!
package com.parse.starter.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainActivity$$ViewBinder<T extends com.parse.starter.ui.MainActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492950, "field 'mAddMessage'");
    target.mAddMessage = finder.castView(view, 2131492950, "field 'mAddMessage'");
  }

  @Override public void unbind(T target) {
    target.mAddMessage = null;
  }
}
