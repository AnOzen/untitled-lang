$$
\begin{align}
[\text{Exit}] &\to \text{exit}([\text{Expr}]);\\
[\text{Set}] &\to \text{env.put}(\text{name},[\text{Expr}]); \\
[\text{Expr}] &\to
\begin{cases}
\text{ExprInt}\\
\text{ExprVar}\\
\end{cases}\\
\end{align}
$$