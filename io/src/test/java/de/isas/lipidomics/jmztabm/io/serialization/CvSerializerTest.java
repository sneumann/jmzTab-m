/* 
 * Copyright 2018 Leibniz-Institut für Analytische Wissenschaften – ISAS – e.V..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.isas.lipidomics.jmztabm.io.serialization;

import de.isas.lipidomics.jmztabm.io.AbstractSerializerTest;
import com.fasterxml.jackson.databind.ObjectWriter;
import de.isas.mztab1_1.model.CV;
import de.isas.mztab1_1.model.Metadata;
import static de.isas.mztab1_1.model.Metadata.PrefixEnum.MTD;
import org.junit.Test;
import static uk.ac.ebi.pride.jmztab1_1.model.MZTabConstants.NEW_LINE;
import static uk.ac.ebi.pride.jmztab1_1.model.MZTabConstants.TAB_STRING;

/**
 *
 * @author Leibniz-Institut für Analytische Wissenschaften – ISAS – e.V.
 */
public class CvSerializerTest extends AbstractSerializerTest {

    /**
     * Test of serialize method, of class ContactSerializer.
     */
    @Test
    public void testSerialize() throws Exception {
        ObjectWriter writer = metaDataWriter();

        Metadata mtd = new Metadata();

        mtd.addCvItem(new CV().id(1).
            label("MS").
            fullName("PSI-MS ontology").
            version("3.54.0").
            url("https://raw.githubusercontent.com/HUPO-PSI/psi-ms-CV/master/psi-ms.obo"));
        mtd.addCvItem(new CV().id(2).
            label("CHEBI").
            fullName("Chebi ontology").
            version("164").
            url("ftp://ftp.ebi.ac.uk/pub/databases/chebi/ontology/chebi.obo"));

        assertEqSentry(
            MTD + TAB_STRING + Metadata.Properties.cv + "[1]-label" + TAB_STRING + "MS" + NEW_LINE
            + MTD + TAB_STRING + Metadata.Properties.cv + "[1]-url" + TAB_STRING + "https://raw.githubusercontent.com/HUPO-PSI/psi-ms-CV/master/psi-ms.obo" + NEW_LINE
            + MTD + TAB_STRING + Metadata.Properties.cv + "[1]-version" + TAB_STRING + "3.54.0" + NEW_LINE
            + MTD + TAB_STRING + Metadata.Properties.cv + "[1]-full_name" + TAB_STRING + "PSI-MS ontology" + NEW_LINE
            + MTD + TAB_STRING + Metadata.Properties.cv + "[2]-label" + TAB_STRING + "CHEBI" + NEW_LINE
            + MTD + TAB_STRING + Metadata.Properties.cv + "[2]-url" + TAB_STRING + "ftp://ftp.ebi.ac.uk/pub/databases/chebi/ontology/chebi.obo" + NEW_LINE
            + MTD + TAB_STRING + Metadata.Properties.cv + "[2]-version" + TAB_STRING + "164" + NEW_LINE
            + MTD + TAB_STRING + Metadata.Properties.cv + "[2]-full_name" + TAB_STRING + "Chebi ontology" + NEW_LINE,
            serialize(writer, mtd));
    }

}
