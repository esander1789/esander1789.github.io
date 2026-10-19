---
layout: archive
title: "Curriculum Vitae"
subtitle: "Evelyn Sander"
permalink: /cv/
author_profile: true
redirect_from:
  - /resume
---

{% include base_path %}

Address
======

Department of Mathematical Sciences  
George Mason University, MS 3F2   
4400 University Drive  
Fairfax, VA 22030   

Research Interests
======

My research is primarily in the fields of dynamical systems and mathematical visualization and design.  Current dynamical work focuses on studying systems with chaos and quasiperiodicity, and on developing rigorous computational methods for bifurcation theory. Visualization work concentrates on using 3D printing to create tangible objects from abstract mathematical concepts, and to design experimental objects to test mathematical models. 

Education
======
* Ph.D in Mathematics, University of Minnesota, 1996, R. McGehee, advisor.
* M.S. in Mathematics, University of Minnesota, 1993.
* B.A. in Mathematics, Northwestern University, 1990, Honors, Phi Beta Kappa

Recent Employment
======

- August 25, 2012 - Professor, George Mason University.
- August 2023 - Graduate Director, Department of Mathematical Sciences, George Mason University.
- 2020 - Member of the Mason Institute for Digital Innovation

Recent Publications
======
  {% assign items = site.publications | reverse %}<ul>{% for post in items limit:10 %}
    {% include archive-single-cv.html %}
  {% endfor %}</ul>

{% assign earlier = items.size | minus: 10 %}{% if earlier > 0 %} {% endif %}See the [Publications](/publications/) page for the full list of publications.

Recent Talks
======
  {% assign items = site.talks | reverse %}<ul>{% for post in items limit:10 %}
    {% include archive-single-talk-cv.html %}
  {% endfor %}</ul>

{% assign earlier = items.size | minus: 10 %}{% if earlier > 0 %}Plus earlier talks. {% endif %}See the [Talks](/talks/) page for the full list.

Recent Teaching
======
  {% assign items = site.teaching | reverse %}<ul>{% for post in items limit:10 %}
    {% include archive-single-cv.html %}
  {% endfor %}</ul>

See the [Teaching](/teaching/) page for the full list.

Recent Grants, Fellowships, and Awards
======

- September 1, 2019 - August 31, 2024, Simons Collaboration Grant, "Computation and visualization of dynamical structures" $42,000.

Service and leadership
======
* Graduate Director, Department of Mathematical Sciences, George Mason University, August 2023 - present
* Member of the SIAM Journal Committee, 2026 - 2028
* Member of the SIAM Council, 2022 - 2027
* Associate Editor, SIAM Journal on Applied Dynamical Systems, 2010 - present
* Editor in Chief, SIAM Journal on Applied Dynamical Systems, 2018 - 2023
* See the [Service](/service/) page for editorial, professional, conference and department service.


