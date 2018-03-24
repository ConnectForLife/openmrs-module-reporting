/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.reporting.data.visit.library;

import org.junit.Before;
import org.junit.Test;
import org.openmrs.Visit;
import org.openmrs.contrib.testdata.TestDataManager;
import org.openmrs.module.reporting.data.visit.EvaluatedVisitData;
import org.openmrs.module.reporting.data.visit.definition.VisitDataDefinition;
import org.openmrs.module.reporting.data.visit.service.VisitDataService;
import org.openmrs.module.reporting.evaluation.EvaluationException;
import org.openmrs.module.reporting.evaluation.context.VisitEvaluationContext;
import org.openmrs.module.reporting.query.visit.VisitIdSet;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BuiltInVisitDataLibraryTest extends BaseModuleContextSensitiveTest {

    @Autowired
    private TestDataManager data;

    @Autowired
    private BuiltInVisitDataLibrary library;

    @Autowired
    private VisitDataService visitDataService;

    private VisitEvaluationContext context;

    private Visit v1;

    private VisitIdSet visitIdSet;

    @Before
    public void setup() throws Exception {

        v1 = data.visit().patient(7)
                .visitType(1)
                .location("Xanadu")
                .started(new Date()).save();

        visitIdSet = new VisitIdSet(v1.getId());
        context = new VisitEvaluationContext();
        context.setBaseVisits(visitIdSet);

    }

    @Test
    public void testVisitId() throws EvaluationException {
        VisitDataDefinition definition = library.getVisitId();
        EvaluatedVisitData data = visitDataService.evaluate(definition, context);
        assertThat((Integer) data.getData().get(v1.getId()), is(v1.getId()));
    }

}
