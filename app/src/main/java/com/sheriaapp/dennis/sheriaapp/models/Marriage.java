package com.sheriaapp.dennis.sheriaapp.models;

import java.util.List;

/**
 * Created by charles on 10/12/17.
 */

public class Marriage {

        private List<String> bloodRelationMarriages = null;
        private List<String> voidMarriages = null;
        private List<String> voidableMarriages = null;
        private List<String> spousesAndTheLawOfTort = null;
        private List<String> iNeedABreak = null;
        private List<String> widower = null;
        private List<String> durationOfMarriage = null;

        public Marriage() {
        }
        public Marriage(List<String> bloodRelationMarriages, List<String> voidMarriages, List<String> voidableMarriages, List<String> spousesAndTheLawOfTort, List<String> iNeedABreak, List<String> widower, List<String> durationOfMarriage) {
            super();
            this.bloodRelationMarriages = bloodRelationMarriages;
            this.voidMarriages = voidMarriages;
            this.voidableMarriages = voidableMarriages;
            this.spousesAndTheLawOfTort = spousesAndTheLawOfTort;
            this.iNeedABreak = iNeedABreak;
            this.widower = widower;
            this.durationOfMarriage = durationOfMarriage;
        }

        public List<String> getBloodRelationMarriages() {
            return bloodRelationMarriages;
        }

        public List<String> getVoidMarriages() {
            return voidMarriages;
        }

        public List<String> getVoidableMarriages() {
            return voidableMarriages;
        }

        public List<String> getSpousesAndTheLawOfTort() {
            return spousesAndTheLawOfTort;
        }

        public List<String> getINeedABreak() {
            return iNeedABreak;
        }

        public List<String> getWidower() {
            return widower;
        }


        public List<String> getDurationOfMarriage() {
            return durationOfMarriage;
        }
}
