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

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import static de.isas.lipidomics.jmztabm.io.serialization.Serializers.addLineWithProperty;
import static de.isas.lipidomics.jmztabm.io.serialization.Serializers.addSubElementStrings;
import static de.isas.lipidomics.jmztabm.io.serialization.Serializers.addLineWithPropertyParameters;
import de.isas.mztab1_1.model.Assay;
import de.isas.mztab1_1.model.Metadata;
import de.isas.mztab1_1.model.MsRun;
import de.isas.mztab1_1.model.Sample;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import uk.ac.ebi.pride.jmztab1_1.model.Section;
import static uk.ac.ebi.pride.jmztab1_1.model.Section.Metadata;

/**
 * <p>AssaySerializer class.</p>
 *
 * @author nilshoffmann
 * 
 */
public class AssaySerializer extends StdSerializer<Assay> {

    /**
     * <p>Constructor for AssaySerializer.</p>
     */
    public AssaySerializer() {
        this(null);
    }

    /**
     * <p>Constructor for AssaySerializer.</p>
     *
     * @param t a {@link java.lang.Class} object.
     */
    public AssaySerializer(Class<Assay> t) {
        super(t);
    }

    /** {@inheritDoc} */
    @Override
    public void serialize(Assay assay, JsonGenerator jg, SerializerProvider sp) throws IOException {
        if (assay != null) {
            addLineWithProperty(jg, Section.Metadata.getPrefix(), null, assay,
                assay.
                    getName());
            
            addLineWithProperty(jg, Section.Metadata.getPrefix(), Assay.Properties.externalUri.getPropertyName(),
                assay, assay.getExternalUri());

            addSubElementStrings(jg, Section.Metadata.getPrefix(), assay, Assay.Properties.custom.getPropertyName(), assay.getCustom(), false);
//            addLineWithPropertyParameters(jg, Section.Metadata.getPrefix(),
//                Assay.Properties.custom.getPropertyName(),
//                assay, assay.getCustom());

            List<MsRun> msRunRef = assay.getMsRunRef();
            if (msRunRef != null) {
                addSubElementStrings(jg, Section.Metadata.getPrefix(), assay,
                    Assay.Properties.msRunRef.getPropertyName(), msRunRef.
                        stream().
                        sorted(Comparator.comparing(MsRun::getId,
                            Comparator.nullsFirst(Comparator.
                                naturalOrder())
                        )).
                        map((mref) ->
                        {
                            return new StringBuilder().append(de.isas.mztab1_1.model.Metadata.Properties.msRun.getPropertyName()).
                                append("[").
                                append(mref.getId()).
                                append("]").
                                toString();
                        }).
                        collect(Collectors.toList()), true);
            }
            Sample sampleRef = assay.getSampleRef();
            if (sampleRef != null) {
                addSubElementStrings(jg, Section.Metadata.getPrefix(), assay,
                    Assay.Properties.sampleRef.getPropertyName(), Arrays.asList(sampleRef).
                        stream().
                        sorted(Comparator.comparing(Sample::getId,
                            Comparator.nullsFirst(Comparator.
                                naturalOrder())
                        )).
                        map((sref) ->
                        {
                            return new StringBuilder().append(de.isas.mztab1_1.model.Metadata.Properties.sample.getPropertyName()).
                                append("[").
                                append(sref.getId()).
                                append("]").
                                toString();
                        }).
                        collect(Collectors.toList()), true);
            }

        } else {
            Logger.getLogger(AssaySerializer.class.getName()).
                log(Level.FINE, Assay.class.getSimpleName()+" is null!");
        }
    }
}
