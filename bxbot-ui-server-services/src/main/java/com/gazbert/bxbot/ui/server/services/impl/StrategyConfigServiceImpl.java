/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Gareth Jon Lynch
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.gazbert.bxbot.ui.server.services.impl;

import com.gazbert.bxbot.ui.server.domain.strategy.StrategyConfig;
import com.gazbert.bxbot.ui.server.repository.StrategyConfigRepository;
import com.gazbert.bxbot.ui.server.services.StrategyConfigService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Implementation of the Strategy config service.
 *
 * @author gazbert
 */
@Service("strategyConfigService")
@Transactional
@ComponentScan(basePackages = {"com.gazbert.bxbot.repository"})
public class StrategyConfigServiceImpl implements StrategyConfigService {

    private static final Logger LOG = LogManager.getLogger();

    private final StrategyConfigRepository strategyConfigRepository;

    @Autowired
    public StrategyConfigServiceImpl(StrategyConfigRepository strategyConfigRepository) {
        Assert.notNull(strategyConfigRepository, "strategyConfigRepository dependency cannot be null!");
        this.strategyConfigRepository = strategyConfigRepository;
    }

    @Override
    public List<StrategyConfig> findAllStrategies() {
        return strategyConfigRepository.findAllStrategies();
    }

    @Override
    public StrategyConfig findById(String id) {
        LOG.info(() -> "Fetching config for Strategy id: " + id);
        return strategyConfigRepository.findById(id);
    }

    @Override
    public StrategyConfig updateStrategy(StrategyConfig config) {
        LOG.info(() -> "About to update: " + config);
        return strategyConfigRepository.updateStrategy(config);
    }

    @Override
    public StrategyConfig createStrategy(StrategyConfig config) {
        LOG.info(() -> "About to create: " + config);
        return strategyConfigRepository.createStrategy(config);
    }

    @Override
    public StrategyConfig deleteStrategyById(String id) {
        LOG.info(() -> "About to delete Strategy config for id: " + id);
        return strategyConfigRepository.deleteStrategyById(id);
    }
}