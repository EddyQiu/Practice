package com.practice.travels;

    public enum Rate{
        CHILD   (0.75),
        CONCESSION  (0.5),
        ADULT   (1),
        SENIOR  (0.25);

        private Double rates;
        Rate(double _rates) {
            this.rates = _rates;
        }
    }