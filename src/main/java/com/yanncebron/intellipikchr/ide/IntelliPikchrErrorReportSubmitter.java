/*
 * Copyright 2021 The Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yanncebron.intellipikchr.ide;

import com.intellij.ide.BrowserUtil;
import com.intellij.ide.plugins.IdeaPluginDescriptor;
import com.intellij.ide.plugins.PluginManagerCore;
import com.intellij.openapi.application.ApplicationInfo;
import com.intellij.openapi.diagnostic.ErrorReportSubmitter;
import com.intellij.openapi.diagnostic.IdeaLoggingEvent;
import com.intellij.openapi.diagnostic.SubmittedReportInfo;
import com.intellij.openapi.util.SystemInfo;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.util.Consumer;
import com.yanncebron.intellipikchr.IntelliPikchrBundle;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class IntelliPikchrErrorReportSubmitter extends ErrorReportSubmitter {

    @NonNls
    private static final String REPORT_URL = "https://github.com/YannCebron/IntelliPikchr/issues/new?labels=crash-report&title=";

    @NotNull
    @Override
    public String getReportActionText() {
        return IntelliPikchrBundle.message("error.report.action.text");
    }

    @Override
    public boolean submit(IdeaLoggingEvent @NotNull [] events,
                          @Nullable String additionalInfo,
                          @NotNull Component parentComponent,
                          @NotNull Consumer<? super SubmittedReportInfo> consumer) {
        IdeaLoggingEvent event = events[0];
        final String throwableText = event.getThrowableText();

        final StringBuilder sb = new StringBuilder(REPORT_URL);

        sb.append(URLEncoder.encode(StringUtil.splitByLines(throwableText)[0], StandardCharsets.UTF_8));
        sb.append("&body=");


        sb.append(URLEncoder.encode("\n\n### Description\n", StandardCharsets.UTF_8));
        sb.append(URLEncoder.encode(StringUtil.defaultIfEmpty(additionalInfo, ""), StandardCharsets.UTF_8));

        sb.append(URLEncoder.encode("\n\n### Steps to Reproduce\n", StandardCharsets.UTF_8));
        sb.append(URLEncoder.encode("Please provide code sample if applicable", StandardCharsets.UTF_8));

        sb.append(URLEncoder.encode("\n\n### Message\n", StandardCharsets.UTF_8));
        sb.append(URLEncoder.encode(StringUtil.defaultIfEmpty(event.getMessage(), ""), StandardCharsets.UTF_8));

        sb.append(URLEncoder.encode("\n\n### Runtime Information\n", StandardCharsets.UTF_8));
        final IdeaPluginDescriptor descriptor = PluginManagerCore.getPlugin(getPluginDescriptor().getPluginId());
        assert descriptor != null;
        sb.append(URLEncoder.encode("Plugin version : " + descriptor.getVersion() + "\n", StandardCharsets.UTF_8));
        sb.append(URLEncoder.encode("IDE: " + ApplicationInfo.getInstance().getFullApplicationName() +
                " (" + ApplicationInfo.getInstance().getBuild().asString() + ")\n", StandardCharsets.UTF_8));
        sb.append(URLEncoder.encode("OS: " + SystemInfo.getOsNameAndVersion(), StandardCharsets.UTF_8));

        sb.append(URLEncoder.encode("\n\n### Stacktrace\n", StandardCharsets.UTF_8));
        sb.append(URLEncoder.encode("```\n", StandardCharsets.UTF_8));
        sb.append(URLEncoder.encode(throwableText, StandardCharsets.UTF_8));
        sb.append(URLEncoder.encode("```\n", StandardCharsets.UTF_8));

        BrowserUtil.browse(sb.toString());

        consumer.consume(new SubmittedReportInfo(SubmittedReportInfo.SubmissionStatus.NEW_ISSUE));
        return true;
    }
}
