The KDE class is a general Java class for 2-dimensional kernel density estimation. 

This code as used in the work of:

Lichman, Moshe, and Padhraic Smyth. "Modeling Human Location Data with Mixtures of Kernel Densities." In Proceedings of the 20th ACM SIGKDD international conference on Knowledge discovery and data mining, pp. 35-44. ACM, 2014.

In our work we describe the details for the differences between the Adaptive to Fixed method of the KDE. Both are available
in the code.

We also explain shortly on the fast implementation using "kd-trees" like dividing the space. This implementation follows the work of Alex Gray's "Dual Tree" evaluation algorithm; see Gray and Moore, "Very Fast Multivariate Kernel Density Estimation using via Computational Geometry", in Proceedings, Joint Stat. Meeting 2003 for more details.

Provided in the code - a simple parser of data file (/dataManager/SimpleDataParser.java) and a simple example script
that shows the use of both adaptive and fixed KDE using a simple data file (/prop/simple_data).

For any questions - please feel free to send an email to mlichman@uci.edu (Moshe Lichman).

