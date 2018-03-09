class
[[deprecated]] flaky {
};
 
[[deprecated("Consider using something other than cranky")]]
int cranky()
{
   return 0;
}
 
int main()
{
  flaky f;
  return cranky();
}
