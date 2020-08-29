#!/bin/bash
set -e

echo "Starting Play App Server"

sbt 'run ${PORT:-80}'