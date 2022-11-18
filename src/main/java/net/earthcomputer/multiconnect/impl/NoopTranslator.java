package net.earthcomputer.multiconnect.impl;

import io.netty.channel.Channel;
import net.earthcomputer.multiconnect.api.IMulticonnectTranslator;
import net.earthcomputer.multiconnect.api.IMulticonnectTranslatorApi;

public class NoopTranslator implements IMulticonnectTranslator {
    @Override
    public int priority() {
        return Integer.MIN_VALUE;
    }

    @Override
    public boolean isApplicableInEnvironment(IMulticonnectTranslatorApi api) {
        return true;
    }

    @Override
    public void init(IMulticonnectTranslatorApi api) {
    }

    @Override
    public void inject(Channel channel) {
    }

    @Override
    public void postPipelineModifiers(Channel channel) {
    }
}
