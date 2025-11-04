$$
\begin{align}
[\text{Exit}] &\to \text{exit}([\text{Expr}]);\\
[\text{Set}] &\to \text{env.put}(\text{name},[\text{Expr}]); \\
[\text{Expr}] &\to
\begin{cases}
\text{ExprInt}\\
\text{ExprVar}\\
[\text{ExprBin}]\\
\end{cases}\\
[\text{ExprBin}] &\to 
\begin{cases}
\text{ExprAdd}([\text{Expr}],[\text{Expr}])\\
\end{cases}
\end{align}
$$