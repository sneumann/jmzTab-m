/*
 * Copyright 2018 Nils Hoffmann <nils.hoffmann@isas.de>.
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
package uk.ac.ebi.pride.jmztab1_1.model;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import static uk.ac.ebi.pride.jmztab1_1.model.Section.Comment;
import static uk.ac.ebi.pride.jmztab1_1.model.Section.Metadata;
import static uk.ac.ebi.pride.jmztab1_1.model.Section.PSM;
import static uk.ac.ebi.pride.jmztab1_1.model.Section.PSM_Header;
import static uk.ac.ebi.pride.jmztab1_1.model.Section.Peptide;
import static uk.ac.ebi.pride.jmztab1_1.model.Section.Peptide_Header;
import static uk.ac.ebi.pride.jmztab1_1.model.Section.Protein;
import static uk.ac.ebi.pride.jmztab1_1.model.Section.Protein_Header;
import static uk.ac.ebi.pride.jmztab1_1.model.Section.Small_Molecule;
import static uk.ac.ebi.pride.jmztab1_1.model.Section.Small_Molecule_Evidence;
import static uk.ac.ebi.pride.jmztab1_1.model.Section.Small_Molecule_Evidence_Header;
import static uk.ac.ebi.pride.jmztab1_1.model.Section.Small_Molecule_Feature;
import static uk.ac.ebi.pride.jmztab1_1.model.Section.Small_Molecule_Feature_Header;
import static uk.ac.ebi.pride.jmztab1_1.model.Section.Small_Molecule_Header;

/**
 *
 * @author Nils Hoffmann <nils.hoffmann@isas.de>
 */
public class SectionTest {

    public SectionTest() {
    }

    /**
     * Test of values method, of class Section.
     */
    @Test
    public void testValues() {
    }

    /**
     * Test of valueOf method, of class Section.
     */
    @Test
    public void testValueOf() {
    }

    /**
     * Test of getPrefix method, of class Section.
     */
    @Test
    public void testGetPrefix() {
    }

    /**
     * Test of getName method, of class Section.
     */
    @Test
    public void testGetName() {
    }

    /**
     * Test of getLevel method, of class Section.
     */
    @Test
    public void testGetLevel() {
    }

    /**
     * Test of findSection method, of class Section.
     */
    @Test
    public void testFindSection_int() {
        for(Section s:Section.values()) {
            Assert.assertEquals(s, Section.findSection(s.getLevel()));
        }
    }

    /**
     * Test of isComment method, of class Section.
     */
    @Test
    public void testIsComment() {
        for(Section s:Section.values()) {
            switch(s) {
                case Comment:
                    Assert.assertTrue(s.isComment());
                    break;
                default:
                    Assert.assertFalse(s.isComment());
            }
        }
    }

    /**
     * Test of isMetadata method, of class Section.
     */
    @Test
    public void testIsMetadata() {
        for(Section s:Section.values()) {
            switch(s) {
                case Metadata:
                    Assert.assertTrue(s.isMetadata());
                    break;
                default:
                    Assert.assertFalse(s.isMetadata());
            }
        }
    }

    /**
     * Test of isHeader method, of class Section.
     */
    @Test
    public void testIsHeader() {
        for(Section s:Section.values()) {
            switch(s) {
                case PSM_Header:
                case Peptide_Header:
                case Protein_Header:
                case Small_Molecule_Evidence_Header:
                case Small_Molecule_Feature_Header:
                case Small_Molecule_Header:
                    Assert.assertTrue(s.isHeader());
                    break;
                default:
                    Assert.assertFalse(s.isHeader());
            }
        }
    }

    /**
     * Test of isData method, of class Section.
     */
    @Test
    public void testIsData() {
                for(Section s:Section.values()) {
            switch(s) {
                case PSM_Header:
                case Peptide_Header:
                case Protein_Header:
                case Small_Molecule_Evidence_Header:
                case Small_Molecule_Feature_Header:
                case Small_Molecule_Header:
                case Comment:
                case Metadata:
                    Assert.assertFalse(s.isData());
                    break;
                default:
                    Assert.assertTrue(s.isData());
            }
        }
    }

    /**
     * Test of toHeaderSection method, of class Section.
     */
    @Test
    public void testToHeaderSection() {
        Assert.assertEquals(Section.Peptide_Header, Section.toHeaderSection(
            Section.Peptide));
        Assert.assertEquals(Section.Peptide_Header, Section.toHeaderSection(
            Section.Peptide_Header));

        Assert.assertEquals(Section.Protein_Header, Section.toHeaderSection(
            Section.Protein));
        Assert.assertEquals(Section.Protein_Header, Section.toHeaderSection(
            Section.Protein_Header));

        Assert.assertEquals(Section.PSM_Header, Section.toHeaderSection(
            Section.PSM));
        Assert.assertEquals(Section.PSM_Header, Section.toHeaderSection(
            Section.PSM_Header));

        Assert.assertEquals(Section.Small_Molecule_Header, Section.toHeaderSection(
            Section.Small_Molecule));
        Assert.assertEquals(Section.Small_Molecule_Header, Section.toHeaderSection(
            Section.Small_Molecule_Header));

        Assert.assertEquals(Section.Small_Molecule_Evidence_Header, Section.
            toHeaderSection(
                Section.Small_Molecule_Evidence));
        Assert.assertEquals(Section.Small_Molecule_Evidence_Header, Section.
            toHeaderSection(
                Section.Small_Molecule_Evidence_Header));

        Assert.assertEquals(Section.Small_Molecule_Feature_Header, Section.
            toHeaderSection(
                Section.Small_Molecule_Feature));
        Assert.assertEquals(Section.Small_Molecule_Feature_Header, Section.
            toHeaderSection(
                Section.Small_Molecule_Feature_Header));
        
        Assert.assertNull(Section.toHeaderSection(Section.Comment));
    }

    /**
     * Test of toDataSection method, of class Section.
     */
    @Test
    public void testToDataSection() {
        Assert.assertEquals(Section.Peptide, Section.toDataSection(
            Section.Peptide));
        Assert.assertEquals(Section.Peptide, Section.toDataSection(
            Section.Peptide_Header));

        Assert.assertEquals(Section.Protein, Section.toDataSection(
            Section.Protein));
        Assert.assertEquals(Section.Protein, Section.toDataSection(
            Section.Protein_Header));

        Assert.assertEquals(Section.PSM, Section.toDataSection(
            Section.PSM));
        Assert.assertEquals(Section.PSM, Section.toDataSection(
            Section.PSM_Header));

        Assert.assertEquals(Section.Small_Molecule, Section.toDataSection(
            Section.Small_Molecule));
        Assert.assertEquals(Section.Small_Molecule, Section.toDataSection(
            Section.Small_Molecule_Header));

        Assert.assertEquals(Section.Small_Molecule_Evidence, Section.
            toDataSection(
                Section.Small_Molecule_Evidence));
        Assert.assertEquals(Section.Small_Molecule_Evidence, Section.
            toDataSection(
                Section.Small_Molecule_Evidence_Header));

        Assert.assertEquals(Section.Small_Molecule_Feature, Section.
            toDataSection(
                Section.Small_Molecule_Feature));
        Assert.assertEquals(Section.Small_Molecule_Feature, Section.
            toDataSection(
                Section.Small_Molecule_Feature_Header));
        
        Assert.assertNull(Section.toDataSection(Section.Comment));
    }

    /**
     * Test of findSection method, of class Section.
     */
    @Test
    public void testFindSection_String() {
        Assert.assertNull(Section.findSection(null));

        Assert.assertEquals(Section.Comment, Section.findSection("comment"));
        Assert.assertEquals(Section.Comment, Section.findSection("COM"));

        Assert.assertEquals(Section.Metadata, Section.findSection("metadata"));
        Assert.assertEquals(Section.Metadata, Section.findSection("MTD"));

        Assert.assertEquals(Section.PSM, Section.findSection("psm"));
        Assert.assertEquals(Section.PSM, Section.findSection("PSM"));
        Assert.assertEquals(Section.PSM_Header, Section.
            findSection("psm_header"));
        Assert.assertEquals(Section.PSM_Header, Section.findSection("PSH"));

        Assert.assertEquals(Section.Peptide, Section.findSection("peptide"));
        Assert.assertEquals(Section.Peptide, Section.findSection("PEP"));
        Assert.assertEquals(Section.Peptide_Header, Section.findSection(
            "peptide_header"));
        Assert.assertEquals(Section.Peptide_Header, Section.findSection("PEH"));

        Assert.assertEquals(Section.Protein, Section.findSection("protein"));
        Assert.assertEquals(Section.Protein, Section.findSection("PRT"));
        Assert.assertEquals(Section.Protein_Header, Section.findSection(
            "protein_header"));
        Assert.assertEquals(Section.Protein_Header, Section.findSection("PRH"));

        Assert.assertEquals(Section.Small_Molecule, Section.findSection(
            "small_molecule"));
        Assert.assertEquals(Section.Small_Molecule, Section.findSection("SML"));
        Assert.assertEquals(Section.Small_Molecule_Header, Section.findSection(
            "small_molecule_header"));
        Assert.assertEquals(Section.Small_Molecule_Header, Section.findSection(
            "SMH"));

        Assert.assertEquals(Section.Small_Molecule_Feature, Section.findSection(
            "small_molecule_feature"));
        Assert.assertEquals(Section.Small_Molecule_Feature, Section.findSection(
            "SMF"));
        Assert.assertEquals(Section.Small_Molecule_Feature_Header, Section.
            findSection("small_molecule_feature_header"));
        Assert.assertEquals(Section.Small_Molecule_Feature_Header, Section.
            findSection("SFH"));

        Assert.assertEquals(Section.Small_Molecule_Evidence, Section.
            findSection("small_molecule_evidence"));
        Assert.assertEquals(Section.Small_Molecule_Evidence, Section.
            findSection("SME"));
        Assert.assertEquals(Section.Small_Molecule_Evidence_Header, Section.
            findSection("small_molecule_evidence_header"));
        Assert.assertEquals(Section.Small_Molecule_Evidence_Header, Section.
            findSection("SEH"));
    }

    /**
     * Test of findSection method, of class Section.
     */
    @Test
    public void testFindSection_Object() {
    }

}